package daos

import scala.concurrent.Future

import daos.tables.JournalTable
import models.Journal

trait JournalDAO extends BaseDAO[JournalTable, Journal] {
  def findByProductId(productId: Long): Future[Option[Journal]]
}
