package routes

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.{Directives, Route}
import domains.Course
import util.{JsonSupport, LoggingSupport}

trait CourseRoutes
  extends Directives
    with JsonSupport
    with LoggingSupport {

  def courseRoutes: Route = {
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
