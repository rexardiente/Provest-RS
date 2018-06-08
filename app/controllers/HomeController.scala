package controllers

import javax.inject.{ Inject, Singleton }
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global
import akka.actor._
import akka.stream._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.mvc.WebSocket._
import play.api.data.Forms._
import play.api.libs.json._
import play.api.libs.streams._
import play.api.libs.openid._
import actors.ClientManagerActor

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
    implicit system: ActorSystem,
    openIdClient: OpenIdClient,
    c: ControllerComponents,
    implicit val ec: ExecutionContext,
    implicit val materializer: Materializer,
    implicit val configuration: play.api.Configuration
  ) extends AbstractController(c) {
  implicit val messageFlowTransformer = MessageFlowTransformer.jsonMessageFlowTransformer[JsValue, JsValue]
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
  */

  def ws = WebSocket.accept[JsValue, JsValue] { implicit request =>
    ActorFlow.actorRef(out => ClientManagerActor.props(out))
  }
}
