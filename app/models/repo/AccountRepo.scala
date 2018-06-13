package models.repo

import java.util.UUID
import javax.inject._
import scala.concurrent.{ ExecutionContext, Future }
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import cats.data.{ EitherT, OptionT }
import cats.implicits._
import models.domain.Account

@Singleton
class AccountRepo @Inject()(
    dao: models.dao.AccountDAO,
    protected val dbConfigProvider: DatabaseConfigProvider,
    implicit val ec: ExecutionContext)
  extends HasDatabaseConfigProvider[utils.db.PostgresDriver] {
  import driver.api._

  def exists(idAccountRef: UUID): Future[Boolean] = db.run(dao.Query(idAccountRef).exists.result)

  def get: Future[Seq[Account]] = db.run(dao.Query.result)

  def getByIds(idAccountRef: Seq[UUID]): Future[Seq[Account]] =
    db.run(dao.Query.filter(_.idAccountRef inSetBind idAccountRef).result)

  def find(idAccountRef: UUID): OptionT[Future, Account] =
    OptionT(db.run(dao.Query(idAccountRef).result.headOption))

  def add(account: Account): Future[Int] = db.run(dao.Query += account)

  def delete(idAccountRef: UUID): Future[Int] = db.run(dao.Query(idAccountRef).delete)

  def update(account: Account): Future[Int] =
    db.run(dao.Query(account.idAccountRef).update(account))
}
