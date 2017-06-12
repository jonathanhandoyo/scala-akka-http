package routes

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.{Directives, Route}
import domains.{Metric, User}
import util.{JsonSupport, LoggingSupport}

trait UserRoutes
  extends Directives
    with UserMetricsRoutes
    with JsonSupport
    with LoggingSupport {

  def usersRoutes: Route = {
    pathPrefix("users") {
      pathEnd {
        getUsers ~
        postUser
      }
      pathPrefix(LongNumber) { (userId: Long) =>
        pathEnd {
          getUser(userId) ~
          putUser(userId)
        } ~
        metricsRoutes(userId)
      }
    }
  }

  private def getUsers: Route = {
    get {
      complete {
        OK -> Array(User(1, "first-name-1", "last-name-1"))
      }
    }
  }

  private def postUser: Route = {
    post {
      entity(as[User]) { (body: User) =>
        complete {
          Created -> body
        }
      }
    }
  }

  private def getUser(userId: Long): Route = {
    get {
      complete {
        OK -> User(userId, "first-name-1", "last-name-1")
      }
    }
  }

  private def putUser(userId: Long): Route = {
    put {
      entity(as[User]) { (body: User) =>
        complete {
          OK -> body
        }
      }
    }
  }
}
