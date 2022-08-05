package sbtgiter8resolver

import sbt.template.TemplateResolver
import giter8.{LauncherProcessor, Runner}

class Giter8TemplateResolver extends TemplateResolver {
  def isDefined(args0: Array[String]): Boolean = {
    val args = args0.toList filterNot { _.startsWith("-") }
    // Mandate .g8
    val Github = """^([^\s/]+)/([^\s/]+?)(?:\.g8)$""".r
    val Local = """^file://(\S+)(?:\.g8)(?:/)?$""".r
    object GitUrl {
      val NativeUrl = "^(git[@|://].*)$".r
      val HttpsUrl = "^(https://.*)$".r
      val HttpUrl = "^(http://.*)$".r
      val SshUrl = "^(ssh://.*)$".r
      def unapplySeq(s: String): Option[List[String]] =
        NativeUrl.unapplySeq(s) orElse
          HttpsUrl.unapplySeq(s) orElse
          HttpUrl.unapplySeq(s) orElse
          SshUrl.unapplySeq(s)
    }
    args.headOption match {
      case Some(Github(_, _)) => true
      case Some(Local(_))     => true
      case Some(GitUrl(uri))  => uri.mkString("") endsWith (".g8.git")
      case _                  => false
    }
  }
  def run(args: Array[String]): Unit = {
    // This calls giter8-launcher, which then reads from project/build.properties
    // file of the template repo to determine the actual Giter8 version to run.
    val runner: Runner = new Runner()
    runner.run(args, new LauncherProcessor)
    ()
  }
}
