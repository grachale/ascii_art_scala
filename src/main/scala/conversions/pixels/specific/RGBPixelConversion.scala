package conversions.pixels.specific

import conversions.pixels.PixelConversion
import models.pixels.specific.{GrayPixel, RGBPixel}

class RGBPixelConversion extends PixelConversion {

  /**
   * Calculates gray value of RGB pixel and creates GrayPixel
   *
   * @return Gray pixel
   */
  def grayValue(pixel: RGBPixel): GrayPixel = GrayPixel(((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt)

}
