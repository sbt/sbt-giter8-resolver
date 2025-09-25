import Dependencies._

def baseVersion: String = "0.2.0-SNAPSHOT"

val scala212 = "2.12.20"
val scala3 = "3.7.3"

ThisBuild / crossScalaVersions := Vector(scala212, scala3)
ThisBuild / version := {
  val old = (ThisBuild / version).value
  (sys.env.get("BUILD_VERSION")) match {
    case Some(v) => v
    case _ =>
      if ((ThisBuild / isSnapshot).value) baseVersion
      else old
  }
}
ThisBuild / organization := "org.scala-sbt.sbt-giter8-resolver"
ThisBuild / scalaVersion := "2.12.10"
ThisBuild / homepage := Some(url("https://github.com/sbt/sbt-giter8-resolver"))
ThisBuild / description := "template resolver for sbt new command with Giter8 support"
ThisBuild / licenses := Seq(
  "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / developers := List(
  Developer("eed3si9n",
            "Eugene Yokota",
            "@eed3si9n",
            url("https://github.com/eed3si9n"))
)
ThisBuild / scmInfo := Some(
  ScmInfo(url("https://github.com/sbt/sbt-giter8-resolver"),
          "git@github.com:sbt/sbt-giter8-resolver.git"))
ThisBuild / pomIncludeRepository := { _ =>
  false
}
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

lazy val root = (project in file("."))
  .settings(
    name := "sbt-giter8-resolver",
    libraryDependencies ++= Vector(
                              templateResolverApi,
                              giter8Launcher,
                              launcherInterface % Provided,
                              verify % Test,
                            ),
    testFrameworks += new TestFramework("verify.runner.Framework"),
  )
