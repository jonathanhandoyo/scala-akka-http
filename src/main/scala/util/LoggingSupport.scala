package util

import akka.event.LoggingAdapter

trait LoggingSupport {
  implicit val logger: LoggingAdapter
}
