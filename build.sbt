name := """Provest_Real_State"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  ws,
  guice,
  openId,
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "com.github.tminglei" %% "slick-pg" % "0.15.2",
  "com.typesafe.akka" %% "akka-remote" % "2.5.12",
  "com.typesafe.akka" %% "akka-actor" % "2.5.12",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

