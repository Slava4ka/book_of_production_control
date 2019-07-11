package models

import org.joda.time.DateTime

case class Product(
  id: Long = 0,
  name: String,
  description: String,
  ingredients: String,
  cost: Int,
  price: Int,
  created: DateTime = DateTime.now,
  deleted: Option[DateTime] = None,
  updated: DateTime = DateTime.now
) extends BaseEntity[Product] {
  override def setId(id: Long): Product = copy(id = id)
}

object Product