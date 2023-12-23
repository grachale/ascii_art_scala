package conversions.images.specific

import conversions.images.ImageConversion
import models.images.specific.AsciiImage

class AsciiImageConversion extends ImageConversion {

  /**
   * Creates text representation of AsciiImage
   *
   * @return text representation of image
   */
  def toString(image: AsciiImage) : String = image.image.map(row => row.mkString).mkString("\n")

}
