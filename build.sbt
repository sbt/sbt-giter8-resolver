import Dependencies._

def baseVersion: String = "0.1.1"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.scala-sbt.sbt-giter8-resolver",
      git.baseVersion := baseVersion,
      homepage := Some(url("https://github.com/sbt/sbt-giter8-resolver")),
      description := "template resolver for sbt new command with Giter8 support",
      licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
      developers := List(
        Developer("eed3si9n", "Eugene Yokota", "@eed3si9n", url("https://github.com/eed3si9n"))
      ),
      scmInfo := Some(ScmInfo(url("https://github.com/sbt/sbt-giter8-resolver"), "git@github.com:sbt/sbt-giter8-resolver.git"))
    )),
    name := "sbt-giter8-resolver",
    libraryDependencies ++= List(templateResolverApi, giter8, launcherInterface % Provided),
    bintrayOrganization := Some("sbt"),
    bintrayRepository := "maven-releases",
    bintrayPackage := "sbt-giter8-resolver",
    bintrayReleaseOnPublish := false
  )
