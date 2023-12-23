package parsers.specific

import transforms.specific.{BourkeTransformationTable, CustomTransformationTable, NonLinearTransformationTable}

import org.scalatest.FunSuite

class ImageTransformParserTests extends FunSuite {

  test("Parse empty arguments") {
    val parser = new ImageTransformParser
    val result = parser.parse(Array.empty[String])
    assert(result.isEmpty)
  }

  test("Parse Bourke standard transformation table") {
    val parser = new ImageTransformParser
    val result = parser.parse(Array("--table", "bourke_standard"))
    assert(result.isDefined)
    assert(result.get.isInstanceOf[BourkeTransformationTable])
  }

  test("Parse non-linear transformation table") {
    val parser = new ImageTransformParser
    val result = parser.parse(Array("--table", "non_linear"))
    assert(result.isDefined)
    assert(result.get.isInstanceOf[NonLinearTransformationTable])
  }

  test("Parse custom transformation table") {
    val parser = new ImageTransformParser
    val result = parser.parse(Array("--custom-table", "$@B%8&W"))
    assert(result.isDefined)
    assert(result.get.isInstanceOf[CustomTransformationTable])
    assert(result.get.asInstanceOf[CustomTransformationTable].symbols === Array('$', '@', 'B', '%', '8', '&', 'W'))
  }

  test("Parse unsupported predefined transformation table") {
    val parser = new ImageTransformParser
    assertThrows[Exception] {
      parser.parse(Array("--table", "unknown_table"))
    }
  }

  test("Parse missing name for predefined transformation table") {
    val parser = new ImageTransformParser
    assertThrows[Exception] {
      parser.parse(Array("--table"))
    }
  }

  test("Parse missing symbols for custom transformation table") {
    val parser = new ImageTransformParser
    assertThrows[Exception] {
      parser.parse(Array("--custom-table"))
    }
  }

}
