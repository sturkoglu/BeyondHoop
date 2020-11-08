val ScalatraVersion = "2.7.0"

organization := "com.rotterdam"

name := "Beyond Hoop"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.3"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.28.v20200408" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.postgresql" % "postgresql" % "42.2.14"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
