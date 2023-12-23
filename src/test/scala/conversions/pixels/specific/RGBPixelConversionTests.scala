package conversions.pixels.specific

import models.pixels.specific.{GrayPixel, RGBPixel}
import org.scalatest.FunSuite

class RGBPixelConversionTests extends FunSuite {

  test("Regular values 1") {
    val rgbPixel: RGBPixel = RGBPixel(10, 20, 30)
    val conversion: RGBPixelConversion = new RGBPixelConversion

    assert(conversion.grayValue(rgbPixel) == GrayPixel(18))
  }

  test("Regular values 2") {
    val rgbPixel: RGBPixel = RGBPixel(70, 200, 1)
    val conversion: RGBPixelConversion = new RGBPixelConversion

    assert(conversion.grayValue(rgbPixel) == GrayPixel(139))
  }

  test("Edge values 1") {
    val rgbPixel: RGBPixel = RGBPixel(255, 255, 255)
    val conversion: RGBPixelConversion = new RGBPixelConversion

        assert(conversion.grayValue(rgbPixel) == GrayPixel(255))
  }

  test("Edge values 2") {
    val rgbPixel: RGBPixel = RGBPixel(0, 0, 0)
    val conversion: RGBPixelConversion = new RGBPixelConversion

        assert(conversion.grayValue(rgbPixel) == GrayPixel(0))
  }

  test("Edge values 3") {
    val rgbPixel: RGBPixel = RGBPixel(255, 0, 255)
    val conversion: RGBPixelConversion = new RGBPixelConversion

    assert(conversion.grayValue(rgbPixel) == GrayPixel(104))
  }

  test("Edge values 4") {
    val rgbPixel: RGBPixel = RGBPixel(0, 0, 255)
    val conversion: RGBPixelConversion = new RGBPixelConversion

    assert(conversion.grayValue(rgbPixel) == GrayPixel(28))
  }

}
