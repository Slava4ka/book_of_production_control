package daos.mysql

import scala.concurrent.Future

import com.github.tototoshi.slick.MySQLJodaSupport._
import com.google.inject.Inject
import daos.JournalDAO
import daos.tables.JournalTable
import models.Journal
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery

class JournalMysql @Inject()(
  protected val dbConfigProvider: DatabaseConfigProvider
) extends BaseMysql[JournalTable, Journal](TableQuery[JournalTable]) with JournalDAO {
  override def findByProductId(productId: Long): Future[Option[Journal]] = {

    // возвращает первый элемент из seq, по идее там должен быть только один

    val action = ENTITIES.filter(entity => entity.product_id === productId && entity.deleted.isEmpty)

    db.run(action.result.headOption)
  }
}
