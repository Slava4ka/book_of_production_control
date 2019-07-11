package daos

import scala.concurrent.Future

import daos.tables.BaseTable
import models.BaseEntity

trait BaseDAO[T <: BaseTable[E], E <: BaseEntity[E]] {

  def findAll: Future[Seq[E]]

  def findOneById(id: Long): Future[Option[E]]

  def findSeveralById(ids: Seq[Long]): Future[Seq[E]]

  def insert(entity: E): Future[Long]

  def update(entity: E): Future[Int]

  def delete(id: Long): Future[Int]

  def blockOne(id: Long): Future[Int]

  def blockSeveral(ids: Seq[Long]): Future[Int]

  def unblockOne(id: Long): Future[Int]

  def unblockSeveral(ids: Seq[Long]): Future[Int]

}
