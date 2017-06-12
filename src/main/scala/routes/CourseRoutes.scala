package routes

import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer
import domains.Course
import util.JsonSupport

import scala.concurrent.ExecutionContext

trait CourseRoutes extends Directives with JsonSupport {

  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer
  implicit val executionContext: ExecutionContext
  implicit val logger: LoggingAdapter

  val courseRoutes: Route = {
    path("courses") {
      get {
        complete {
          logger.info("test test")
          OK -> Course(1, "a")
        }
      }
    }
  }
}
