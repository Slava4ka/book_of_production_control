/*
█████████████████████████
█────███────██────██────█
█─██──██─██─██─██─██─██─█
█────███─██─██────██─████
█─██──██─██─██─█████─██─█
█────███────██─█████────█
█████████████████████████
 */

name := """BoPC"""
organization := "Vyacheslav"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  guice,
  evolutions,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test,
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "mysql" % "mysql-connector-java" % "8.0.15",
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0"
)
