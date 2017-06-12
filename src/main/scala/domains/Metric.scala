package domains

case class Metric(userId: Long,
                  portfolioId: Long,
                  code: String,
                  counter: Long,
                  start: Long)
