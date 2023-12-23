package parsers.specific

import exporters.text.{FileTextExporter, StdOutputTextExporter}
import org.scalatest.FunSuite

class ImageOutputParserTests extends FunSuite {

  test("Parse empty arguments") {
    val parser = new ImageOutputParser
    val result = parser.parse(Array.empty[String])
    assert(result.isEmpty)
  }

  test("Parse console output argument") {
    val parser = new ImageOutputParser
    val result = parser.parse(Array("--output-console"))
    assert(result.length === 1)
    assert(result.head.isInstanceOf[StdOutputTextExporter])
  }

  test("Parse file output argument") {
    val parser = new ImageOutputParser
    val result = parser.parse(Array("--output-file", "output.txt"))
    assert(result.length === 1)
    assert(result.head.isInstanceOf[FileTextExporter])
    assert(result.head.asInstanceOf[FileTextExporter].path === "output.txt")
  }

  test("Parse multiple output arguments") {
    val parser = new ImageOutputParser
    val result = parser.parse(Array("--output-console", "--output-file", "output.txt"))
    assert(result.length === 2)
    assert(result.head.isInstanceOf[StdOutputTextExporter])
    assert(result(1).isInstanceOf[FileTextExporter])
    assert(result(1).asInstanceOf[FileTextExporter].path === "output.txt")
  }

  test("Parse missing path for file output") {
    val parser = new ImageOutputParser
    assertThrows[Exception] {
      parser.parse(Array("--output-file"))
    }
  }

}
