package conversions.images.specific

import models.images.specific.{AsciiImage, GrayImage}
import models.pixels.specific.GrayPixel
import transforms.specific.CustomTransformationTable

import org.scalatest.FunSuite

class GrayImageConversionTests extends FunSuite {

  test("Custom table 1") {
    val grayImage: GrayImage = GrayImage(Array(Array(GrayPixel(234), GrayPixel(2)),
                                               Array(GrayPixel(0), GrayPixel(55))))

    val conversion: GrayImageConversion = new GrayImageConversion
    val transformationTable: CustomTransformationTable = new CustomTransformationTable(" ".toCharArray)

    val convertedImage: AsciiImage = conversion.toAscii(grayImage, transformationTable)

    assert(convertedImage.image(0)(0) == ' ')
    assert(convertedImage.image(1)(0) == ' ')
    assert(convertedImage.image(0)(1) == ' ')
    assert(convertedImage.image(1)(1) == ' ')
  }

  test("Custom table 2") {
    val grayImage: GrayImage = GrayImage(Array(Array(GrayPixel(255), GrayPixel(0)),
                                               Array(GrayPixel(0), GrayPixel(255))))

    val conversion: GrayImageConversion = new GrayImageConversion
    val transformationTable: CustomTransformationTable = new CustomTransformationTable("# ".toCharArray)

    val convertedImage: AsciiImage = conversion.toAscii(grayImage, transformationTable)

    assert(convertedImage.image(0)(0) == ' ')
    assert(convertedImage.image(1)(0) == '#')
    assert(convertedImage.image(0)(1) == '#')
    assert(convertedImage.image(1)(1) == ' ')
  }

  test("Custom table 3") {
    val grayImage: GrayImage = GrayImage(Array(Array(GrayPixel(255), GrayPixel(75)),
                                               Array(GrayPixel(75), GrayPixel(0))))

    val conversion: GrayImageConversion = new GrayImageConversion
    val transformationTable: CustomTransformationTable = new CustomTransformationTable("#0 ".toCharArray)

    val convertedImage: AsciiImage = conversion.toAscii(grayImage, transformationTable)

    assert(convertedImage.image(0)(0) == ' ')
    assert(convertedImage.image(1)(0) == '0')
    assert(convertedImage.image(0)(1) == '0')
    assert(convertedImage.image(1)(1) == '#')
  }

}
