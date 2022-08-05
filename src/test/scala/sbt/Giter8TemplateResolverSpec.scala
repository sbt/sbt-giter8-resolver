package sbtgiter8resolver

import org.scalatest.funsuite.AnyFunSuite

class Giter8TemplateResolverSpec extends AnyFunSuite {
  val resolver = new Giter8TemplateResolver

  test("GitHub pattern") {
    assert(resolver.isDefined(Array("scala/scala-seed.g8")) == true)
  }

  test("Local pattern") {
    assert(
      resolver.isDefined(Array("file://path/to/scala/scala-seed.g8")) == true)
  }

  test("Native URL pattern") {
    assert(resolver
      .isDefined(Array("git://git@github.com:scala/scala-seed.g8.git")) == true)
  }

  test("HTTPS URL Pattern") {
    assert(
      resolver
        .isDefined(Array("https://github.com/scala/scala-seed.g8.git")) == true)
  }

  test("HTTP URL Pattern") {
    assert(
      resolver
        .isDefined(Array("http://github.com/scala/scala-seed.g8.git")) == true)
  }

  test("SSH URL Pattern") {
    assert(
      resolver
        .isDefined(Array("ssh://user@host/scala/scala-seed.g8.git")) == true)
  }

  test("invalid pattern 1") {
    assert(resolver.isDefined(
      Array("ftp://user:pass@host/scala/scala-seed.g8.git")) == false)
  }

  test("invalid pattern 2") {
    assert(
      resolver
        .isDefined(Array("https://github.com/scala/scala-seed.g8")) == false)
  }
}
