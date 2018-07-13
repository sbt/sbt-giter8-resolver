import Dependencies._

def baseVersion: String = "0.1.3-SNAPSHOT"

lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "org.scala-sbt.sbt-giter8-resolver",
      git.baseVersion := baseVersion,
      scalaVersion := "2.10.7",
      crossScalaVersions := List("2.10.7", "2.12.6"),
      homepage := Some(url("https://github.com/sbt/sbt-giter8-resolver")),
      description := "template resolver for sbt new command with Giter8 support",
      licenses := Seq(
        "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
      developers := List(
        Developer("eed3si9n",
                  "Eugene Yokota",
                  "@eed3si9n",
                  url("https://github.com/eed3si9n"))
      ),
      scmInfo := Some(ScmInfo(url("https://github.com/sbt/sbt-giter8-resolver"),
                              "git@github.com:sbt/sbt-giter8-resolver.git"))
    )),
  name := "sbt-giter8-resolver",
  libraryDependencies ++= List(templateResolverApi,
                               giter8,
                               launcherInterface % Provided),
  bintrayOrganization := Some("sbt"),
  bintrayRepository := "maven-releases",
  bintrayPackage := "sbt-giter8-resolver",
  bintrayReleaseOnPublish := false,
  relaxNon212
)

def relaxNon212: Seq[Setting[_]] = Seq(
  scalacOptions := {
    val old = scalacOptions.value
    scalaBinaryVersion.value match {
      case "2.12" => old
      case _ =>
        old filterNot Set("-Xfatal-warnings",
                          "-deprecation",
                          "-Ywarn-unused",
                          "-Ywarn-unused-import")
    }
  }
)
