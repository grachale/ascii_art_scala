package conversions.images.specific

import conversions.images.ImageConversion
import models.images.specific.{AsciiImage, GrayImage}
import transforms.TransformationTable

class GrayImageConversion extends ImageConversion {

  /**
   * Creates ascii image. Transforms each gray pixel with transformation function into char.
   *
   * @param transformationTable class which represents transformation table
   * @return ascii image represented as 2d array
   */
  def toAscii(image: GrayImage, transformationTable: TransformationTable): AsciiImage = {

    var asciiArray = Array.ofDim[Char](image.height(), image.width())

    for (i <- 0 until image.height())
      for (j <- 0 until image.width())
        asciiArray(i)(j) = transformationTable.transform(image.image(i)(j).value)

    AsciiImage(asciiArray)
  }

}
