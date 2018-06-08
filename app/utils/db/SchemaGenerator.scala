package utils.db

import javax.inject.{ Inject, Singleton }
import play.api.Logger
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
// import models.dao._

@Singleton
class SchemaGenerator @Inject()(
    // tradeWalletDAO: TradeWalletDAO,
    val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[utils.db.PostgresDriver] {
  import profile.api._

  def createDDLScript() = {
    // val schemas =
      // transactionsDAO.Query.schema ++
      // orderBookSummaryDAO.Query.schema

    val writer = new java.io.PrintWriter("target/schema.sql")
    writer.write("# --- !Ups\n\n")
    // schemas.createStatements.foreach { s => writer.write(s + ";\n\n") }

    writer.write("\n\n# --- !Downs\n\n")
    // schemas.dropStatements.foreach { s => writer.write(s + ";\n") }

    Logger.debug("Schema definitions are written")

    writer.close()
  }

  createDDLScript()
}

// Note: Uncomment after providing those important data.
