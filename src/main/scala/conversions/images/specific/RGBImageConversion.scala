package conversions.images.specific

import conversions.images.ImageConversion
import models.images.specific.RGBImage
import models.images.specific.GrayImage
import models.pixels.specific.GrayPixel
import conversions.pixels.specific.RGBPixelConversion

class RGBImageConversion extends ImageConversion {

  /**
   * Creates gray image from RGB one with grayValue conversion for each pixel
   *
   * @param image RGB image, which must be converted to grey one
   * @return gray image represented
   */
  def toGrey(image: RGBImage) : GrayImage = {

    var grayImage = Array.ofDim[GrayPixel](image.height(), image.width())
    val rgbPixelConverter = new RGBPixelConversion

    for (i <- 0 until image.height())
      for (j <- 0 until image.width())
        grayImage(i)(j) = rgbPixelConverter.grayValue(image.image(i)(j))

    GrayImage(grayImage)
  }

}
