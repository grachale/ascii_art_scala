package loaders.image.specific

import models.pixels.specific.RGBPixel
import org.scalatest.FunSuite

class RandomImageLoaderTests extends FunSuite {

  test("Load random image with valid dimensions"){
    val loader = new RandomImageLoader
    val image = loader.load()

    assert(image != null)

    // check if the image dimensions are valid (greater than or equal to 100)
    assert(image.width >= 100)
    assert(image.height >= 100)

    // check if all pixels in the image are RGBPixels
    assert(image.image.flatten.forall(_.isInstanceOf[RGBPixel]))
  }

}
