import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import routes.UserRoutes

import scala.concurrent.ExecutionContextExecutor

class AkkaHttpApp extends UserRoutes {
}

object AkkaHttpApp {
  def main(args: Array[String]): Unit = {

    implicit val system: ActorSystem = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val app = new AkkaHttpApp()

    Http().bindAndHandle(app.usersRoutes, "localhost", 8080)
    system.log.info(s"test: http://localhost:8080/hello")
  }
}
