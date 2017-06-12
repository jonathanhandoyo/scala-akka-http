import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import routes.{CourseRoutes, UserRoutes}

import scala.concurrent.ExecutionContextExecutor

object AkkaHttpApp
  extends CourseRoutes
    with UserRoutes {

  implicit val system: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  implicit val logger: LoggingAdapter = system.log

  val routes: Route = {
    usersRoutes ~
    courseRoutes
  }

  def main(args: Array[String]): Unit = {
    Http().bindAndHandle(routes, "localhost", 8080)
    system.log.info(s"test: http://localhost:8080/hello")
  }
}
