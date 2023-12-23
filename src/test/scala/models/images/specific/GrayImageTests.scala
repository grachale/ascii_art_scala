package models.images.specific

import models.pixels.specific.GrayPixel
import org.scalatest.FunSuite

class GrayImageTests extends FunSuite {

  test("Values") {
    var array2d = Array(Array(GrayPixel(2), GrayPixel(3)), Array(GrayPixel(4), GrayPixel(5)))
    var grayImage = GrayImage(array2d)

    assert(grayImage.image(0)(0) == GrayPixel(2))
    assert(grayImage.image(0)(1) == GrayPixel(3))
    assert(grayImage.image(1)(0) == GrayPixel(4))
    assert(grayImage.image(1)(1) == GrayPixel(5))
  }

  test("Dimensions 2x2") {
    var array2d = Array(Array(GrayPixel(2), GrayPixel(3)), Array(GrayPixel(4), GrayPixel(5)))
    var grayImage = GrayImage(array2d)

    assert(grayImage.width() == 2)
    assert(grayImage.height() == 2)
  }

  test("Dimensions 3x2") {
    var array2d = Array(Array(GrayPixel(2), GrayPixel(3)),
                        Array(GrayPixel(4), GrayPixel(5)),
                        Array(GrayPixel(2), GrayPixel(3)))
    var grayImage = GrayImage(array2d)

    assert(grayImage.width() == 2)
    assert(grayImage.height() == 3)
  }

  test("Dimensions 2x3") {
    var array2d = Array(Array(GrayPixel(2), GrayPixel(3), GrayPixel(3)),
                  Array(GrayPixel(2), GrayPixel(3), GrayPixel(3)))
    var grayImage = GrayImage(array2d)

    assert(grayImage.width() == 3)
    assert(grayImage.height() == 2)
  }

  test("Dimensions 3x3") {
    var array2d = Array(Array(GrayPixel(2), GrayPixel(3), GrayPixel(3)),
                        Array(GrayPixel(4), GrayPixel(5), GrayPixel(3)),
                        Array(GrayPixel(4), GrayPixel(5), GrayPixel(3)))

    var grayImage = GrayImage(array2d)

    assert(grayImage.width() == 3)
    assert(grayImage.height() == 3)
  }

}

