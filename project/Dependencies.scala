import sbt._
import Keys._

object Dependencies {
  lazy val templateResolverApi = "org.scala-sbt" % "template-resolver" % "0.1"
  lazy val giter8 = "org.foundweekends.giter8" %% "giter8" % "0.7.1"
  lazy val launcherInterface = "org.scala-sbt" % "launcher-interface" % "1.0.0-M1"
}
