package models.pixels.specific

import org.scalatest.FunSuite

class RGBPixelTests extends FunSuite {

  test("Regular values 1") {
    var rgbPixel: RGBPixel = RGBPixel(10, 10, 10)
    assert(rgbPixel.red == 10)
    assert(rgbPixel.green == 10)
    assert(rgbPixel.blue == 10)
  }

  test("Regular values 2") {
    var rgbPixel: RGBPixel = RGBPixel(12, 14, 234)
    assert(rgbPixel.red == 12)
    assert(rgbPixel.green == 14)
    assert(rgbPixel.blue == 234)
  }

  test("Edge values 1") {
    var rgbPixel: RGBPixel = RGBPixel(255, 255, 255)
    assert(rgbPixel.red == 255)
    assert(rgbPixel.green == 255)
    assert(rgbPixel.blue == 255)
  }

  test("Edge values 2") {
    var rgbPixel: RGBPixel = RGBPixel(0, 0, 0)
    assert(rgbPixel.red == 0)
    assert(rgbPixel.green == 0)
    assert(rgbPixel.blue == 0)
  }

  test("Change pixel values") {
    var rgbPixel: RGBPixel = RGBPixel(0, 0, 0)
    assert(rgbPixel.red == 0)
    assert(rgbPixel.green == 0)
    assert(rgbPixel.blue == 0)

    rgbPixel = RGBPixel(2, 3, 4)
    assert(rgbPixel.red == 2)
    assert(rgbPixel.green == 3)
    assert(rgbPixel.blue == 4)
  }

}
