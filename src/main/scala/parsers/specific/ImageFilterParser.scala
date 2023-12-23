package parsers.specific

import filters.image.ascii.AsciiImageFilter
import filters.image.ascii.mixed.FilterImageAsciiMixed
import filters.image.ascii.specific.{FlipAsciiImageFilter, RotateAsciiImageFilter, ScaleAsciiImageFilter}
import parsers.ArgumentParser

class ImageFilterParser extends ArgumentParser {

  /**
   * Parses arguments and returns parsed sequence of filters as FilterImageAsciiMixed.
   *
   * @param args Array of string arguments, which must be parsed
   *  @return FilterImageAsciiMixed mixed of filters that parsed
   */
  override def parse(args: Array[String]): FilterImageAsciiMixed = {

    var filters: Array[AsciiImageFilter] = Array.empty[AsciiImageFilter]

    for ((arg, index) <- args.zipWithIndex) {
      val nextIndex = index + 1
      arg match {
        case "--rotate" => {
          if (nextIndex < args.length)
            filters = filters :+ new RotateAsciiImageFilter(args(nextIndex).toInt)
          else
            throw new Exception("Unspecified rotate degrees.")
        }
        case "--scale" => {
          if (nextIndex < args.length)
            filters = filters :+ new ScaleAsciiImageFilter(args(nextIndex).toDouble)
          else
            throw new Exception("Unspecified scale value.")
        }
        case "--flip" => {
          if (nextIndex < args.length)
            filters = filters :+ new FlipAsciiImageFilter(args(nextIndex).toCharArray()(0))
          else
            throw new Exception("Unspecified flip axis.")
        }
        case _ => // continue
      }
    }

    new FilterImageAsciiMixed(filters)
  }

}
