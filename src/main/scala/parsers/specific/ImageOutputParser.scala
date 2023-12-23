package parsers.specific

import conversions.images.specific.AsciiImageConversion
import exporters.text.{FileTextExporter, StdOutputTextExporter, TextExporter}
import parsers.ArgumentParser

class ImageOutputParser extends ArgumentParser {

  /**
   * Parses arguments and returns array of corresponded exporters.
   *
   * @param args Array of string arguments, which must be parsed
   * @return array of exporters
   */
  override def parse(args: Array[String]): Array[TextExporter] = {

    var arrayOfExporters: Array[TextExporter] = Array.empty[TextExporter]

    val asciiImageConversion = new AsciiImageConversion()

    for ((arg, index) <- args.zipWithIndex) {
      val nextIndex = index + 1
      arg match {
        case "--output-console" => arrayOfExporters = arrayOfExporters :+ new StdOutputTextExporter
        case "--output-file" => {
          if (nextIndex < args.length)
            arrayOfExporters = arrayOfExporters :+ new FileTextExporter(args(nextIndex))
          else
            throw new Exception("No specified path to file for exporting an image.")
        }
        case _ => // continue
      }
    }

    arrayOfExporters
  }

}
