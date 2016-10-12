import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.scala-sbt.sbt-giter8-resolver",
      version := "0.1.0",
      bintrayOrganization := Some("sbt"),
      bintrayRepository := s"sbt-plugin-releases",
      bintrayPackage := "sbt-giter8-resolver",
      bintrayReleaseOnPublish := false
    )),
    name := "sbt-giter8-resolver",
    libraryDependencies ++= List(templateResolverApi, giter8, launcherInterface % Provided)
  )
