package sbtgiter8resolver

class Giter8TemplateResolverSpec extends verify.BasicTestSuite {
  val resolver = new Giter8TemplateResolver

  test("GitHub pattern") {
    Predef.assert(resolver.isDefined(Array("scala/scala-seed.g8")) == true)
  }

  test("Local pattern") {
    Predef.assert(
      resolver.isDefined(Array("file://path/to/scala/scala-seed.g8")) == true)
  }

  test("Native URL pattern") {
    Predef.assert(resolver
      .isDefined(Array("git://git@github.com:scala/scala-seed.g8.git")) == true)
  }

  test("HTTPS URL Pattern") {
    Predef.assert(
      resolver
        .isDefined(Array("https://github.com/scala/scala-seed.g8.git")) == true)
  }

  test("HTTP URL Pattern") {
    Predef.assert(
      resolver
        .isDefined(Array("http://github.com/scala/scala-seed.g8.git")) == true)
  }

  test("SSH URL Pattern") {
    Predef.assert(
      resolver
        .isDefined(Array("ssh://user@host/scala/scala-seed.g8.git")) == true)
  }

  test("invalid pattern 1") {
    Predef.assert(resolver.isDefined(
      Array("ftp://user:pass@host/scala/scala-seed.g8.git")) == false)
  }

  test("invalid pattern 2") {
    Predef.assert(
      resolver
        .isDefined(Array("https://github.com/scala/scala-seed.g8")) == false)
  }
}
