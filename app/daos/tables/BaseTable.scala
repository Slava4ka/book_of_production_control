package daos.tables

import com.github.tototoshi.slick.MySQLJodaSupport._
import org.joda.time.DateTime
import slick.jdbc.MySQLProfile.api._

import scala.reflect._

abstract class BaseTable[E: ClassTag](tag: Tag, schemaName: String) extends Table[E](tag, schemaName) {
  def id = column[Long]("id", O.AutoInc, O.PrimaryKey)

  def created = column[DateTime]("created")

  def deleted = column[Option[DateTime]]("deleted")

  def updated = column[DateTime]("updated", O.Default(DateTime.now))
}
