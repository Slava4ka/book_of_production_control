package daos.tables

import com.github.tototoshi.slick.MySQLJodaSupport._
import models.Journal
import slick.jdbc.MySQLProfile.api._

class JournalTable(tag: Tag) extends BaseTable[Journal](tag, "journal") {

  val product_id: Rep[Option[Long]] = column[Option[Long]]("product_id ")

  val quantity: Rep[Long] = column[Long]("quantity")

  def * = (
    id,
    product_id,
    quantity,
    created,
    deleted,
    updated) <> ((Journal.apply _).tupled, Journal.unapply)

  def product = foreignKey("fk_journal_product_id", product_id, TableQuery[ProductTable])(
    _.id.?,
    onUpdate = ForeignKeyAction.Restrict,
    onDelete = ForeignKeyAction.Cascade
  )
}
