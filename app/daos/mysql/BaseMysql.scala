package daos.mysql

import scala.concurrent.Future

import daos.BaseDAO
import daos.tables.BaseTable
import models.BaseEntity
import org.joda.time.DateTime
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery

abstract class BaseMysql[T <: BaseTable[E], E <: BaseEntity[E]](clazz: TableQuery[T])
  extends BaseDAO[T, E] with HasDatabaseConfigProvider[JdbcProfile] {

  val ENTITIES: TableQuery[T] = clazz

  override def findAll: Future[Seq[E]] = {
    db.run(ENTITIES.result)
  }

  override def findOneById(id: Long): Future[Option[E]] = {
    db.run(ENTITIES.filter(_.id === id).result.headOption)
  }

  override def findSeveralById(ids: Seq[Long]): Future[Seq[E]] = {
    db.run(ENTITIES.filter(_.id inSet ids).result)
  }

  override def insert(entity: E): Future[Long] = {
    val insertQuery = ENTITIES returning ENTITIES.map(_.id) into ((_, id) => id)
    db.run(insertQuery += entity)
  }

  override def update(entity: E): Future[Int] = {
    db.run(ENTITIES.filter(_.id === entity.id).update(entity))
  }

  override def delete(id: Long): Future[Int] = {
    db.run(ENTITIES.filter(_.id === id).delete)
  }

  override def blockOne(id: Long): Future[Int] = {
    val action = ENTITIES.filter(_.id === id)
      .map(entity => (entity.updated, entity.deleted))
      .updade(DateTime.now, Some(DateTime.now))

    db.run(action)
  }

  override def blockSeveral(ids: Seq[Long]): Future[Int] = {
    val action = ENTITIES.filter(_.id inSet ids)
      .map(entity => (entity.updated, entity.deleted))
      .update(DateTime.now, Some(DateTime.now))

    db.run(action)
  }

  override def unblockOne(id: Long): Future[Int] = {
    val action = ENTITIES.filter(_.id === id)
      .map(entity => (entity.updated, entity.deleted))
      .update(DateTime.now(), None)

    db.run(action)
  }

  override def unblockSeveral(ids: Seq[Long]): Future[Int] = {
    val action = ENTITIES.filter(_.id inSet ids)
      .map(entity => (entity.updated, entity.deleted))
      .update(DateTime.now, None)

    db.run(action)
  }

}
