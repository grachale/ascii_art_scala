package parsers.specific

import loaders.image.specific.{JpgImageLoader, PngImageLoader, RandomImageLoader}

import org.scalatest.FunSuite

class ImageLoaderParserTests extends FunSuite {

  test("Parse empty arguments") {
    val parser = new ImageLoaderParser
    val result = parser.parse(Array.empty[String])
    assert(result.isEmpty)
  }

  test("Parse random image argument") {
    val parser = new ImageLoaderParser
    val result = parser.parse(Array("--image-random"))
    assert(result.isDefined)
    assert(result.get.isInstanceOf[RandomImageLoader])
  }

  test("Parse single JPG image argument") {
    val parser = new ImageLoaderParser
    val result = parser.parse(Array("--image", "example.jpg"))
    assert(result.isDefined)
    assert(result.get.isInstanceOf[JpgImageLoader])
    assert(result.get.asInstanceOf[JpgImageLoader].path === "example.jpg")
  }

  test("Parse single PNG image argument") {
    val parser = new ImageLoaderParser
    val result = parser.parse(Array("--image", "example.png"))
    assert(result.isDefined)
    assert(result.get.isInstanceOf[PngImageLoader])
    assert(result.get.asInstanceOf[PngImageLoader].path === "example.png")
  }

  test("Parse unsupported image format") {
    val parser = new ImageLoaderParser
    assertThrows[Exception] {
      parser.parse(Array("--image", "example.gif"))
    }
  }

  test("Parse missing path for image file") {
    val parser = new ImageLoaderParser
    assertThrows[Exception] {
      parser.parse(Array("--image"))
    }
  }

  test("Parse multiple image arguments") {
    val parser = new ImageLoaderParser
    assertThrows[Exception] {
      parser.parse(Array("--image", "example.jpg", "--image", "example.png"))
    }
  }

}
