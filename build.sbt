import Dependencies._

def baseVersion: String = "0.2.0-SNAPSHOT"

ThisBuild / organization := "org.scala-sbt.sbt-giter8-resolver"
ThisBuild / git.baseVersion := baseVersion
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

lazy val root = (project in file("."))
  .settings(
    name := "sbt-giter8-resolver",
    libraryDependencies ++= List(templateResolverApi,
                                 giter8Launcher,
                                 launcherInterface % Provided),
    bintrayOrganization := Some("sbt"),
    bintrayRepository := "maven-releases",
    bintrayPackage := "sbt-giter8-resolver",
    bintrayReleaseOnPublish := false
  )
