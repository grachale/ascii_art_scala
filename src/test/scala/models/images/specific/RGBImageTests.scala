package models.images.specific

import models.pixels.specific.{GrayPixel, RGBPixel}
import org.scalatest.FunSuite

class RGBImageTests extends FunSuite {

  test("Values") {
    var array2d = Array(Array(RGBPixel(1, 2, 3), RGBPixel(4, 5, 6)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12)))
    var rgbImage = RGBImage(array2d)

    assert(rgbImage.image(0)(0) == RGBPixel(1, 2, 3))
    assert(rgbImage.image(0)(1) == RGBPixel(4, 5, 6))
    assert(rgbImage.image(1)(0) == RGBPixel(7, 8, 9))
    assert(rgbImage.image(1)(1) == RGBPixel(10, 11, 12))
  }

  test("Dimensions 2x2") {
    var array2d = Array(Array(RGBPixel(1, 2, 3), RGBPixel(4, 5, 6)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12)))
    var rgbImage = RGBImage(array2d)

    assert(rgbImage.width() == 2)
    assert(rgbImage.height() == 2)
  }

  test("Dimensions 3x2") {
    var array2d = Array(Array(RGBPixel(1, 2, 3), RGBPixel(4, 5, 6)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12)))
    var rgbImage = RGBImage(array2d)

    assert(rgbImage.width() == 2)
    assert(rgbImage.height() == 3)
  }

  test("Dimensions 2x3") {
    var array2d = Array(Array(RGBPixel(1, 2, 3), RGBPixel(4, 5, 6), RGBPixel(4, 5, 6)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12), RGBPixel(4, 5, 6)))
    var rgbImage = RGBImage(array2d)

    assert(rgbImage.width() == 3)
    assert(rgbImage.height() == 2)
  }

  test("Dimensions 3x3") {
    var array2d = Array(Array(RGBPixel(1, 2, 3), RGBPixel(4, 5, 6), RGBPixel(4, 5, 6)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12), RGBPixel(4, 5, 6)),
                        Array(RGBPixel(7, 8, 9), RGBPixel(10, 11, 12), RGBPixel(4, 5, 6)))
    var rgbImage = RGBImage(array2d)

    assert(rgbImage.width() == 3)
    assert(rgbImage.height() == 3)
  }


}

