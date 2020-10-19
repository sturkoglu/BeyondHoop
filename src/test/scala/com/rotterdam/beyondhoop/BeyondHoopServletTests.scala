package com.rotterdam.beyondhoop

import org.scalatra.test.scalatest._

class BeyondHoopServletTests extends ScalatraFunSuite {

  addServlet(classOf[BeyondHoopServlet], "/*")

  test("GET / on BeyondHoopServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
