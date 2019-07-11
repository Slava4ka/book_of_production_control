package models

import org.joda.time.DateTime

case class Journal(
  id: Long = 0,
  product_id: Option[Long],
  quantity: Long,
  created: DateTime = DateTime.now,
  deleted: Option[DateTime] = None,
  updated: DateTime = DateTime.now
) extends BaseEntity[Journal] {
  override def setId(id: Long): Journal = copy(id = id)
}

object Journal