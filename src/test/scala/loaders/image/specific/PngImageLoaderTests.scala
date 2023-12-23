package loaders.image.specific

import models.images.specific.RGBImage
import models.pixels.specific.RGBPixel

import org.scalatest.FunSuite

class PngImageLoaderTests extends FunSuite {

  test("Values: image_2x1.png"){
    val loader: JpgImageLoader = new JpgImageLoader("accets/image_2x1.png")
    val image: RGBImage = loader.load()

    assert(image.image(0)(0) == RGBPixel(208,117,80))
    assert(image.image(0)(1) == RGBPixel(211,129,67))
  }

  test("Dimensions: image_2x1.png") {
    val loader: JpgImageLoader = new JpgImageLoader("accets/image_2x1.png")
    val image: RGBImage = loader.load()

    assert(image.width() == 2)
    assert(image.height() == 1)
  }

}
