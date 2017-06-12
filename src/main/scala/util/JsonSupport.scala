package util

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import domains._
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat: RootJsonFormat[Item] = jsonFormat2(Item)
  implicit val orderFormat: RootJsonFormat[Order] = jsonFormat2(Order)

  implicit val userFormat: RootJsonFormat[User] = jsonFormat3(User)
  implicit val courseFormat: RootJsonFormat[Course] = jsonFormat2(Course)
  implicit val metricFormat: RootJsonFormat[Metric] = jsonFormat5(Metric)
}
