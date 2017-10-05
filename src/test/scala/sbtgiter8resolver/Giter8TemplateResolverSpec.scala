package sbtgiter8resolver

import org.scalatest.{ MustMatchers, WordSpec }

class Giter8TemplateResolverSpec extends WordSpec with MustMatchers {

  val resolver: Giter8TemplateResolver = new Giter8TemplateResolver()

  val negativeCases: Map[String, String] = Map(
    "template path is a github repo that doesn't end in `.g8`" -> "foo/bar",
    "template path is a file uri which doesn't end in `.g8`" -> "file://foo/bar",
    "template path is an http url which doesn't end in `.g8.git`" -> "http://www.example.com/foo.g8",
    "template path is an https url which doesn't end in `.g8.git`" -> "https://www.example.com/foo.g8",
    "template path is an ssh url which doesn't end in `.g8.git`" -> "ssh://www.example.com/foo.g8"
  )

  ".isDefined" must {

    "return true" when {

      "template path is a github repo ending in `.g8`" in {
        resolver.isDefined(Array("foo/bar.g8")) mustEqual true
      }

      "template path is a file uri which ends in `.g8`" in {
        resolver.isDefined(Array("file://foo/bar.g8")) mustEqual true
      }

      "template path is an http url which ends in `.g8.git`" in {
        resolver.isDefined(Array("http://www.example.com/foo.g8.git")) mustEqual true
      }

      "template path is an https url which ends in `.g8.git`" in {
        resolver.isDefined(Array("https://www.example.com/foo.g8.git")) mustEqual true
      }

      "template path is an ssh url which ends in `.g8.git`" in {
        resolver.isDefined(Array("ssh://www.example.com/foo.g8.git")) mustEqual true
      }

      negativeCases.foreach {
        case (description, setup) =>
          s"$description but `-g8` flag is used" in {
            resolver.isDefined(Array("-g8", setup)) mustEqual true
          }
      }
    }

    "return false" when {

      negativeCases.foreach {
        case (description, setup) =>
        description in {
          resolver.isDefined(Array(setup)) mustEqual false
        }
      }
    }
  }
}
