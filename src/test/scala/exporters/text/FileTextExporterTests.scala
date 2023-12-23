package exporters.text

import helpers.TestWithFiles

import org.scalatest.FunSuite


// test was created by inspiration from tutorials
// comments to demonstrate understanding of the test
class FileTextExporterTests extends FunSuite
  with TestWithFiles {

    test("No file exists") {
      val fileName = getTestFile

      try {
        // ensuring not existence of file
        ensureDeleted(fileName)

        // creating exporter
        val exporter = new FileTextExporter(fileName)

        // export
        exporter.export("Let's go!")
        exporter.close()

        // check file's content
        assertFileContent(fileName, "Let's go!")
      }
      finally {
        // delete file
        ensureDeleted(fileName)
      }
    }

    test("File already exists") {
      val fileName = getTestFile

      try {
        // ensuring existence of file
        ensureCreated(fileName)

        val exporter = new FileTextExporter(fileName)

        exporter.export("Let's go!")
        exporter.close()

        assertFileContent(fileName, "Let's go!")
      }
      finally {
        ensureDeleted(fileName)
      }
    }


  }
