package conversions.images.specific

import models.images.specific.{GrayImage, RGBImage}
import models.pixels.specific.{GrayPixel, RGBPixel}
import org.scalatest.FunSuite

class RGBImageConversionTests extends FunSuite {

  test("Regular values 2x2") {
    val rgbImage: RGBImage = RGBImage(Array(Array(RGBPixel(1, 1, 1), RGBPixel(2, 2, 2)),
                                            Array(RGBPixel(20, 20, 20), RGBPixel(20, 20, 20))))

    val conversion: RGBImageConversion = new RGBImageConversion

    val convertedImage: GrayImage = conversion.toGrey(rgbImage)

    assert(convertedImage.image(0)(0) == GrayPixel(0))
    assert(convertedImage.image(1)(0) == GrayPixel(19))
    assert(convertedImage.image(0)(1) == GrayPixel(1))
    assert(convertedImage.image(1)(1) == GrayPixel(19))
  }

  test("Regular values 3x2") {
    val rgbImage: RGBImage = RGBImage(Array(Array(RGBPixel(1, 1, 1), RGBPixel(2, 2, 2)),
                                            Array(RGBPixel(20, 20, 20), RGBPixel(20, 20, 20)),
                                            Array(RGBPixel(20, 20, 20), RGBPixel(20, 20, 20))))

    val conversion: RGBImageConversion = new RGBImageConversion

    val convertedImage: GrayImage = conversion.toGrey(rgbImage)

    assert(convertedImage.image(0)(0) == GrayPixel(0))
    assert(convertedImage.image(1)(0) == GrayPixel(19))
    assert(convertedImage.image(0)(1) == GrayPixel(1))
    assert(convertedImage.image(1)(1) == GrayPixel(19))
    assert(convertedImage.image(2)(0) == GrayPixel(19))
    assert(convertedImage.image(2)(1) == GrayPixel(19))
  }

  test("Edge values 3x2") {
    val rgbImage: RGBImage = RGBImage(Array(Array(RGBPixel(0, 0, 0), RGBPixel(0, 0, 0)),
                                            Array(RGBPixel(0, 0, 0), RGBPixel(0, 0, 0)),
                                            Array(RGBPixel(255, 255, 255), RGBPixel(255, 255, 255))))

    val conversion: RGBImageConversion = new RGBImageConversion

    val convertedImage: GrayImage = conversion.toGrey(rgbImage)

    assert(convertedImage.image(0)(0) == GrayPixel(0))
    assert(convertedImage.image(1)(0) == GrayPixel(0))
    assert(convertedImage.image(0)(1) == GrayPixel(0))
    assert(convertedImage.image(1)(1) == GrayPixel(0))
    assert(convertedImage.image(2)(0) == GrayPixel(255))
    assert(convertedImage.image(2)(1) == GrayPixel(255))
  }

}
