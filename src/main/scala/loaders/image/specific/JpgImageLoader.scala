package loaders.image.specific

import loaders.image.ImageLoader
import models.images.specific.RGBImage
import models.pixels.specific.RGBPixel

import java.io.File
import javax.imageio.ImageIO

class JpgImageLoader(val path: String) extends ImageLoader {

  /**
   * Loads RGBImage from jpg file.
   *
   *  @return uploaded RGBImage
   */
  override def load(): RGBImage = {
    val file = new File(path)
    val image = ImageIO.read(file)

    val imageHeight = image.getHeight()
    val imageWidth = image.getWidth()

    var pixelMatrix: Array[Array[RGBPixel]] = Array.ofDim[RGBPixel](imageHeight, imageWidth)

    for(i <- 0 until imageHeight) {
      for(j <- 0 until imageWidth) {
        val rgb = image.getRGB(j, i)
        // extracting rgb values from pixel
        val red: Int = (rgb >> 16) & 0xFF
        val green: Int = (rgb >> 8) & 0xFF
        val blue: Int = rgb & 0xFF

        pixelMatrix(i)(j) = RGBPixel(red, green, blue)
      }
    }

    RGBImage(pixelMatrix)
  }

}