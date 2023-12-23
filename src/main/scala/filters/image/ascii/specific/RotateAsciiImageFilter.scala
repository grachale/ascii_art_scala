package filters.image.ascii.specific

import filters.image.ascii.AsciiImageFilter
import models.images.specific.AsciiImage

class RotateAsciiImageFilter(val degree: Int) extends AsciiImageFilter {

  /**
   * Rotates AsciiImage by degree dividable by 90 degrees.
   *
   * @param item The AsciiImage to rotate
   * @return The rotated AsciiImage
   */
  override def filter(item: AsciiImage): AsciiImage = {
    var arrayImage = item.image
    val rotatedArrayImage = degree match {
      case d if d % 360 == 0 => arrayImage
      case d if d % 180 == 0 => arrayImage.reverse.map(_.reverse)
      case d if d % 90 == 0 => {
        val imageHeight = item.height()
        val imageWidth = item.width()

        var rotated: Array[Array[Char]] = Array.ofDim[Char](imageWidth, imageHeight)

        if (((d % 270 != 0) && d > 0) || ((d % 270 == 0) && d < 0))
          for (i <- 0 until imageWidth)
            for (j <- 0 until imageHeight)
              rotated(i)((imageHeight - 1 - j) % imageHeight) = arrayImage(j)(i)
        else
          for (i <- 0 until imageWidth)
            for (j <- 0 until imageHeight)
              rotated(imageWidth - 1 - i)((j) % imageHeight) = arrayImage(j)(i)

        rotated
      }
      case _ => throw new Exception("Unsupported rotation degree.")
    }
    AsciiImage(rotatedArrayImage)
  }

}