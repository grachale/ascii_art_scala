package parsers.specific

import parsers.ArgumentParser
import loaders.image.ImageLoader
import loaders.image.specific.{JpgImageLoader, PngImageLoader, RandomImageLoader}

import scala.util.control.Breaks._

class ImageLoaderParser extends ArgumentParser {

  /**
   * Parses arguments and return image loader
   *
   * @param args Array of string arguments, which must be parsed
   * @return Option[ImageLoader] parsed image loader or None
   */
  override def parse(args: Array[String]): Option[ImageLoader] = {

    var loader: Option[ImageLoader] = None

    // to check number of passed --image args
    var numOfImageArgs = 0

    breakable {
      for ((arg, index) <- args.zipWithIndex) {
        val nextIndex = index + 1
        arg match {
          case "--image-random" => {
            loader = Some(new RandomImageLoader)
            // if random image argument found, must be random, break
            break
          }
          case "--image" => {
            numOfImageArgs += 1
            if (nextIndex < args.length) {
              val filename = args(nextIndex)

              filename match {
                case s if s.endsWith(".jpg") => loader = Some(new JpgImageLoader(args(nextIndex)))
                case s if s.endsWith(".png") => loader = Some(new PngImageLoader(args(nextIndex)))
                case _ => throw new Exception("Unsupported image format.")
              }
            }
            else
              throw new Exception("Unspecified path to file for uploading an image.")
          }
          case _ => // continue
        }
      }
    }

    if (numOfImageArgs > 1)
      throw new Exception("Multiple --image arguments are unsupported.")

    loader
  }

}
