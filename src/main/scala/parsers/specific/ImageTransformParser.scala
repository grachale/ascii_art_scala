package parsers.specific

import parsers.ArgumentParser
import transforms.specific.{BourkeTransformationTable, CustomTransformationTable, NonLinearTransformationTable}
import transforms.TransformationTable

class ImageTransformParser extends ArgumentParser {

  /**
   * Parses arguments and return transformation table according to args
   *
   * @param args Array of string arguments, which must be parsed
   * @return Option[TransformationTable] parsed transformation table or None
   */
  override def parse(args: Array[String]): Option[TransformationTable] = {

    var transformationTable: Option[TransformationTable] = None

    for ((arg, index) <- args.zipWithIndex) {
      val nextIndex = index + 1
      arg match {
        case "--table" => {
          if (nextIndex < args.length)
            args(nextIndex) match {
              case "bourke_standard" => transformationTable = Some(new BourkeTransformationTable)
              case "non_linear" => transformationTable = Some(new NonLinearTransformationTable)
              case _ => throw new Exception("Not known predefined transformation table.")
            }
          else
            throw new Exception("Unspecified name of transformation table.")
        }
        case "--custom-table" => {
          if (nextIndex < args.length)
            transformationTable = Some(new CustomTransformationTable(args(nextIndex).toCharArray))
          else
            throw new Exception("Unspecified symbols of custom table.")
        }
        case _ => // continue
      }
    }

    transformationTable
  }

}
