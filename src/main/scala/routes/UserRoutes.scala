package routes

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer
import domains.User
import util.JsonSupport

import scala.concurrent.ExecutionContext

trait UserRoutes extends Directives with JsonSupport {

  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer
  implicit val executionContext: ExecutionContext
  implicit val logger: LoggingAdapter

  val usersRoutes: Route = {
    pathPrefix("users") {
      pathEnd {
        getUsers ~
        postUsers
      }
    }
  }

  def getUsers: Route = {
    get {
      complete {
        OK -> User(1, "first-name-1", "last-name-1")
      }
    }
  }

  def postUsers: Route = {
    post {
      entity(as[User]) { (body) =>
        complete {
          Created -> body
        }
      }
    }
  }
}
