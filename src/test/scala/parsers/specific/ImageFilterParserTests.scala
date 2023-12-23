package parsers.specific

import filters.image.ascii.mixed.FilterImageAsciiMixed
import filters.image.ascii.specific.{FlipAsciiImageFilter, RotateAsciiImageFilter, ScaleAsciiImageFilter}
import org.scalatest.FunSuite

class ImageFilterParserTests extends FunSuite {

  test("Parse empty arguments") {
    val parser = new ImageFilterParser
    val result: FilterImageAsciiMixed = parser.parse(Array.empty[String])
    assert(result.filters.isEmpty)
  }

  test("Parse single rotate argument") {
    val parser = new ImageFilterParser
    val result = parser.parse(Array("--rotate", "90"))
    assert(result.filters.length == 1)
    assert(result.filters.head.isInstanceOf[RotateAsciiImageFilter])
    assert(result.filters.head.asInstanceOf[RotateAsciiImageFilter].degree === 90)
  }

  test("Parse single scale argument") {
    val parser = new ImageFilterParser
    val result = parser.parse(Array("--scale", "2.0"))
    assert(result.filters.length == 1)
    assert(result.filters.head.isInstanceOf[ScaleAsciiImageFilter])
    assert(result.filters.head.asInstanceOf[ScaleAsciiImageFilter].value === 2.0)
  }

  test("Parse single flip argument") {
    val parser = new ImageFilterParser
    val result = parser.parse(Array("--flip", "x"))
    assert(result.filters.length === 1)
    assert(result.filters.head.isInstanceOf[FlipAsciiImageFilter])
    assert(result.filters.head.asInstanceOf[FlipAsciiImageFilter].axis === 'x')
  }

  test("Parse multiple arguments") {
    val parser = new ImageFilterParser
    val result = parser.parse(Array("--rotate", "90", "--scale", "2.0", "--flip", "y"))
    assert(result.filters.length === 3)
    assert(result.filters.head.isInstanceOf[RotateAsciiImageFilter])
    assert(result.filters(1).isInstanceOf[ScaleAsciiImageFilter])
    assert(result.filters(2).isInstanceOf[FlipAsciiImageFilter])
  }

  test("Parse incomplete arguments - Missing value for rotate") {
    val parser = new ImageFilterParser
    assertThrows[Exception] {
      parser.parse(Array("--rotate"))
    }
  }

  test("Parse incomplete arguments - Missing value for scale") {
    val parser = new ImageFilterParser
    assertThrows[Exception] {
      parser.parse(Array("--scale"))
    }
  }

  test("Parse incomplete arguments - Missing value for flip") {
    val parser = new ImageFilterParser
    assertThrows[Exception] {
      parser.parse(Array("--flip"))
    }
  }

}
