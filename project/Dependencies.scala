import sbt._
import Keys._

object Dependencies {
  lazy val templateResolverApi = "org.scala-sbt" % "template-resolver" % "0.1"
  lazy val giter8 = "org.foundweekends.giter8" %% "giter8" % "0.11.0-M1"
  lazy val launcherInterface = "org.scala-sbt" % "launcher-interface" % "1.0.0-M1"
  lazy val scalactic = "org.scalactic" %% "scalactic" % "3.0.1" % "test"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"
}
