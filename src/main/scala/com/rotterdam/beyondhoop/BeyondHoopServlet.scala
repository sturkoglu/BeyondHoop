package com.rotterdam.beyondhoop

import com.rotterdam.beyondhoop.models.TopicRecord

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import org.scalatra._
import slick.jdbc.PostgresProfile.api._
import slick.util.Logging

class BeyondHoopServlet extends ScalatraServlet with Logging{

  get("/") {
    val connectionUrl = s"jdbc:postgresql://localhost:5433/beyond_meetup?user=postgres&password=mysecretpassword"

    val db = Database.forURL(connectionUrl, driver = "org.postgresql.Driver")

    try {
      val topicQuery = TableQuery[TopicRecord]
      val action = topicQuery.result
      val result: Future[Seq[(Int,String, String, Int, String, Int)]] = db.run(action)
      val futureResult = Await.result(result, Duration.Inf)
      futureResult.map { tname => logger.debug(s"name: ${tname}") }
      views.html.hello(futureResult)
    } finally db.close
  }

}
