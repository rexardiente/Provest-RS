package models.dao

import java.util.UUID
import java.time.Instant
import javax.inject.{ Inject, Singleton }
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import models.domain._
import scala.math.BigDecimal._
import utils._

@Singleton
final class AccountDAO @Inject()(
    protected val dbConfigProvider: DatabaseConfigProvider
  ) extends HasDatabaseConfigProvider[utils.db.PostgresDriver] {
  import driver.api._

  protected class AccountTable(tag: Tag) extends Table[Account](tag, "ACCOUNT") {
    def idAccountRef = column[UUID]("ID_ACCOUNT_REF", O.PrimaryKey)
    def accountName = column[String]("ACCOUNT_NAME")
    def password = column[String]("PASSWORD")
    def email = column[String]("EMAIL")
    def createdAt = column[Instant]("CREATE_AT")

    def * = (idAccountRef, accountName, password, email, createdAt) <> (
      Account.tupled, Account.unapply)
  }

  object Query extends TableQuery(new AccountTable(_)) {
    @inline def apply(accountName: String) = this.withFilter(_.accountName === accountName)
  }
}