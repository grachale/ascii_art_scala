package filters.image.ascii.specific

import filters.image.ascii.AsciiImageFilter
import models.images.specific.AsciiImage

class ScaleAsciiImageFilter(val value: Double) extends AsciiImageFilter {

  /**
   * Scale AsciiImage by values: 0.25, 1, or 4.
   *
   * @param item The AsciiImage to scale
   * @return The scaled AsciiImage
   */
  override def filter(item: AsciiImage): AsciiImage = {
    val imageHeight = item.height()
    val imageWidth = item.width()

    val scaledImage: AsciiImage = value match {
      case 0.25 => {
        if ((imageHeight % 2 == 1) || (imageWidth % 2 == 1))
          throw new Exception("Unsupported dimensions of image for scale 0.25")

        var scaled: Array[Array[Char]] = Array.ofDim[Char](imageHeight / 2, imageWidth / 2)

        for (i <- 0 until imageHeight)
          for (j <- 0 until imageWidth)
              scaled(i / 2)(j / 2) = item.image(i)(j)

        AsciiImage(scaled)
      }
      case 1 => item
      case 4 => {
        var scaled: Array[Array[Char]] = Array.ofDim[Char](imageHeight * 2, imageWidth * 2)

        for (i <- 0 until imageHeight * 2)
          for (j <- 0 until imageWidth * 2)
              scaled(i)(j) = item.image(i / 2)(j / 2)

        AsciiImage(scaled)
      }
      case _ => throw new Exception("Unsupported scale value.")
    }

    scaledImage
  }

}
