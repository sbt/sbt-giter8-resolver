package sbtgiter8resolver

import org.scalatest.{ MustMatchers, WordSpec }

class Giter8TemplateResolverSpec extends WordSpec with MustMatchers {

  val resolver: Giter8TemplateResolver = new Giter8TemplateResolver()

  ".isDefined" must {

    "return true" when {

      "template path is a github repo ending in `.g8`" in {
        resolver.isDefined(Array("foo/bar.g8")) mustEqual true
      }

      "template path is a file uri which ends in `.g8`" in {
        resolver.isDefined(Array("file://foo/bar.g8")) mustEqual true
      }

      "template path is an http url which ends in `.g8`" in {
        resolver.isDefined(Array("http://www.example.com/foo.g8")) mustEqual true
      }

      "template path is an https url which ends in `.g8`" in {
        resolver.isDefined(Array("https://www.example.com/foo.g8")) mustEqual true
      }

      "template path is an ssh url which ends in `.g8`" in {
        resolver.isDefined(Array("ssh://www.example.com/foo.g8")) mustEqual true
      }
    }

    "return false" when {

      "template path is a github repo that doesn't end in `.g8`" in {
        resolver.isDefined(Array("foo/bar")) mustEqual false
      }

      "template path is a file uri which doesn't end in `.g8`" in {
        resolver.isDefined(Array("file://foo/bar")) mustEqual false
      }

      "template path is an http url which doesn't end in `.g8`" in {
        resolver.isDefined(Array("http://www.example.com/foo")) mustEqual false
      }

      "template path is an https url which doesn't end in `.g8`" in {
        resolver.isDefined(Array("https://www.example.com/foo")) mustEqual false
      }

      "template path is an ssh url which doesn't end in `.g8`" in {
        resolver.isDefined(Array("ssh://www.example.com/foo"))
      }
    }
  }
}
