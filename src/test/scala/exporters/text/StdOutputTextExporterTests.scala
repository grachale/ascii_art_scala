package exporters.text

import org.scalatest.FunSuite
import java.io.ByteArrayOutputStream


class StdOutputTextExporterTests extends FunSuite {
  test("Write") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    // export
    exporter.export("Let's do it!")

    // check stream
    assert(stream.toString("UTF-8") == "Let's do it!")
  }

}
