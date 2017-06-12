package util

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import domains.{Course, Item, Order, User}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat: RootJsonFormat[Item] = jsonFormat2(Item)
  implicit val orderFormat: RootJsonFormat[Order] = jsonFormat2(Order)

  implicit val userFormat: RootJsonFormat[User] = jsonFormat3(User)
  implicit val courseFormat: RootJsonFormat[Course] = jsonFormat2(Course)
}
