package sbtgiter8resolver

import sbt.template.TemplateResolver

import scala.util.matching.Regex

class Giter8TemplateResolver extends TemplateResolver {

  def isDefined(args0: Array[String]): Boolean = {

    val args = args0.toList filterNot { _.startsWith("-") }
    // Mandate .g8
    val Github = """^([^\s/]+)/([^\s/]+?)(?:\.g8)$""".r
    val Local = """^file://(\S+)(?:\.g8)(?:/)?$""".r

    object GitUrl {

      val NativeUrl: Regex = "^(git[@|://].*)$".r
      val HttpsUrl: Regex = "^(https://.*)$".r
      val HttpUrl: Regex = "^(http://.*)$".r
      val SshUrl: Regex = "^(ssh://.*)$".r

      def unapplySeq(s: Any): Option[List[String]] =
        NativeUrl.unapplySeq(s) orElse
          HttpsUrl.unapplySeq(s) orElse
          HttpUrl.unapplySeq(s) orElse
          SshUrl.unapplySeq(s)
    }

    args.headOption match {
      case Some(Github(_, _)) => true
      case Some(Local(_))     => true
      case Some(GitUrl(uri))  => uri.mkString("") endsWith ".g8"
      case _                  => false
    }
  }

  def run(args: Array[String]): Unit =
    giter8.Giter8.run(args)
}
