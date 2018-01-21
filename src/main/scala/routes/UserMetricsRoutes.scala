package routes

import akka.http.scaladsl.model.StatusCodes.OK
import akka.http.scaladsl.server.{Directives, Route}
import domains.Metric
import util.{JsonSupport, LoggingSupport}

trait UserMetricsRoutes
  extends Directives
    with JsonSupport
    with LoggingSupport {

  def metricsRoutes(userId: Long): Route = {
    pathPrefix("metrics") {
      pathEnd {
        getUserMetrics(userId) ~
        postUserMetric(userId)
      } ~
      pathPrefix(Segment) { (metricCode: String) =>
        getUserMetric(userId, metricCode) ~
        putUserMetric(userId, metricCode) ~
        deleteUserMetric(userId, metricCode)
      }
    }
  }

  private def getUserMetrics(userId: Long): Route = {
    get {
      parameter('code.as[String]) { (code: String) =>
        complete {
          OK -> Metric(1, 1, code, 1, 1)
        }
      }
    }
  }

  private def postUserMetric(userId: Long): Route = {
    post {
      entity(as[Metric]) { (body: Metric) =>
        complete {
          OK -> body
        }
      }
    }
  }

  private def getUserMetric(userId: Long, metricCode: String) = {
    get {
      complete {
        OK -> Metric(userId, 1, metricCode, 1, 1)
      }
    }
  }

  private def putUserMetric(userId: Long, metricCode: String) = {
    put {
      entity(as[Metric]) { (body: Metric) =>
        complete {
          OK -> body
        }
      }
    }
  }

  private def deleteUserMetric(userId: Long, metricCode: String) = {
    delete {
      complete {
        OK
      }
    }
  }
}
