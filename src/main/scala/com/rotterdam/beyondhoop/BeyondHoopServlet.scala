package com.rotterdam.beyondhoop

import org.scalatra._

class BeyondHoopServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
