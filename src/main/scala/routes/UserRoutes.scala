package routes

import akka.http.scaladsl.server.{Directives, Route}
import domains.Item
import util.JsonSupport

trait UserRoutes extends Directives with JsonSupport {
  val usersRoutes: Route =
    path("users") {
      getUsers ~
      postUsers
    }

  def getUsers: Route = get {
    complete {
      Item(1, "a")
    }
  }

  def postUsers: Route = get {
    complete {
      Item(1, "a")
    }
  }
}
