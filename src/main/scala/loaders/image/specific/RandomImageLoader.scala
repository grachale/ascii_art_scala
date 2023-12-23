package loaders.image.specific

import loaders.image.ImageLoader
import models.images.specific.RGBImage
import models.pixels.specific.RGBPixel

import scala.util.Random

class RandomImageLoader extends ImageLoader {

  /**
   * Generates random ImageRGB with random dimensions (min limit of dimensions set to 100)
   *
   * @return ImageRGB
   */
  override def load(): RGBImage = {
    val random = new Random()

    // random dimensions with min limit set to 100
    val minLimit = 100
    val width = random.nextInt(100) + minLimit
    val height = random.nextInt(100) + minLimit

    var randomImage: Array[Array[RGBPixel]] = Array.ofDim[RGBPixel](height, width)

    // filling in random RGB pixels
    for (i <- 0 until height) {
      for (j <- 0 until width) {
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)

        randomImage(i)(j) = RGBPixel(red, blue, green)
      }
    }

    RGBImage(randomImage)
  }

}
