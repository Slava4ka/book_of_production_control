package daos.tables

import slick.jdbc.MySQLProfile.api._
import models.Product
import com.github.tototoshi.slick.MySQLJodaSupport._

class ProductTable(tag: Tag) extends BaseTable[Product](tag, "product") {

  def name: Rep[String] = column[String]("name")

  def description: Rep[String] = column[String]("description")

  def ingredients: Rep[String] = column[String]("ingredients")

  def cost: Rep[Int] = column[Int]("cost")

  def price: Rep[Int] = column[Int]("price")

  def * = (
    id,
    name,
    description,
    ingredients,
    cost,
    price,
    created,
    deleted,
    updated) <> ((Product.apply _).tupled, Product.unapply)
}