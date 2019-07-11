package models

import org.joda.time.DateTime

trait BaseEntity[T] {
  val id: Long
  val created: DateTime
  val updated: DateTime
  val deleted: Option[DateTime]

  def setId(id: Long): T
}
