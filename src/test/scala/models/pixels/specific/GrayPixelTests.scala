package models.pixels.specific

import org.scalatest.FunSuite

class GrayPixelTests extends FunSuite {

  test("0") {
    var grayPixel: GrayPixel = GrayPixel(0)
    assert(grayPixel.value == 0)
  }
  test("22") {
    var grayPixel: GrayPixel = GrayPixel(22)
    assert(grayPixel.value == 22)
  }
  test("255") {
    var grayPixel: GrayPixel = GrayPixel(0)
    assert(grayPixel.value == 0)
  }
  test("Change pixel value") {
    var grayPixel: GrayPixel = GrayPixel(10)
    assert(grayPixel.value == 10)
    grayPixel = GrayPixel(20)
    assert(grayPixel.value == 20)
  }

}
