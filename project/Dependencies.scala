import sbt._
import Keys._

object Dependencies {
  lazy val templateResolverApi = "org.scala-sbt" % "template-resolver" % "0.1"
  lazy val giter8Launcher = "org.foundweekends.giter8" %% "giter8-launcher" % "0.18.0"
  lazy val launcherInterface = "org.scala-sbt" % "launcher-interface" % "1.3.3"
  lazy val verify = "com.eed3si9n.verify" %% "verify" % "1.0.0"
}
