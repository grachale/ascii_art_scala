package conversions.images.specific

import models.images.specific.AsciiImage

import org.scalatest.FunSuite

class AsciiImageConversionTests extends FunSuite {

  test("2x2") {
    val array2d = Array(Array('a', 'b'), Array('c', 'd'))
    val asciiImage: AsciiImage = AsciiImage(array2d)
    val conversion: AsciiImageConversion = new AsciiImageConversion

    assert(conversion.toString(asciiImage) == "ab\ncd")
  }

  test("3x2") {
    val array2d = Array(Array('a', 'b'), Array('c', 'd'), Array('c', 'd'))
    val asciiImage: AsciiImage = AsciiImage(array2d)
    val conversion: AsciiImageConversion = new AsciiImageConversion

    assert(conversion.toString(asciiImage) == "ab\ncd\ncd")
  }

  test("2x3") {
    val array2d = Array(Array('a', 'b', 'k'), Array('c', 'd', 'e'))
    val asciiImage: AsciiImage = AsciiImage(array2d)
    val conversion: AsciiImageConversion = new AsciiImageConversion

    assert(conversion.toString(asciiImage) == "abk\ncde")
  }

  test("Empty") {
    val array2d = Array(Array[Char](), Array[Char]())
    val asciiImage: AsciiImage = AsciiImage(array2d)
    val conversion: AsciiImageConversion = new AsciiImageConversion

    assert(conversion.toString(asciiImage) == "\n")
  }

}
