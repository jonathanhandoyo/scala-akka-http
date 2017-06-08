package util

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import domains.{Item, Order}
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat = jsonFormat2(Item)
  implicit val orderFormat = jsonFormat2(Order)
}
