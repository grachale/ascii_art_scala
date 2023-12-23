package loaders.image.specific

import models.images.specific.RGBImage
import models.pixels.specific.RGBPixel

import org.scalatest.FunSuite

class JpgImageLoaderTests extends FunSuite {

  test("Values: image_2x1.jpg"){
    val loader: JpgImageLoader = new JpgImageLoader("accets/image_2x1.jpg")
    val image: RGBImage = loader.load()

    assert(image.image(0)(0) == RGBPixel(105,112,120))
    assert(image.image(0)(1) == RGBPixel(113,120,128))
  }

  test("Dimensions: image_2x1.jpg") {
    val loader: JpgImageLoader = new JpgImageLoader("accets/image_2x1.jpg")
    val image: RGBImage = loader.load()

    assert(image.width() == 2)
    assert(image.height() == 1)
  }

}
