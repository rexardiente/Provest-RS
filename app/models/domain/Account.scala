package models.domain

import java.util.UUID
import java.time.Instant
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Account(
    idAccountRef: UUID,
    accountName: String,
    password: String,
    email: String,
    createdAt: Instant)

object Account {
  val tupled = (apply _).tupled

  implicit val readAndWriteFormater: Format[Account] = (
    (__ \ "id_account_ref").format[UUID] and
    (__ \ "account_name").format[String] and
    (__ \ "password").format[String] and
    (__ \ "email").format[String] and
    (__ \ "created_at").format[Instant]
  )(Account.apply _, unlift(Account.unapply _))
}
