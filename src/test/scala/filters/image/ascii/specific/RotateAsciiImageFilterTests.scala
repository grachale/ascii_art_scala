package filters.image.ascii.specific

import models.images.specific.AsciiImage

import org.scalatest.FunSuite

class RotateAsciiImageFilterTests extends FunSuite {

  test("By 0 degrees") {
    val filter = new RotateAsciiImageFilter(0)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By 360 degrees") {
    val filter = new RotateAsciiImageFilter(360)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By 180 degrees") {
    val filter = new RotateAsciiImageFilter(180)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('I', 'H', 'G'),
      Array('F', 'E', 'D'),
      Array('C', 'B', 'A')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By 90 degrees") {
    val filter = new RotateAsciiImageFilter(90)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('G', 'D', 'A'),
      Array('H', 'E', 'B'),
      Array('I', 'F', 'C')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By 270 degrees") {
    val filter = new RotateAsciiImageFilter(270)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('C', 'F', 'I'),
      Array('B', 'E', 'H'),
      Array('A', 'D', 'G')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By -90 degrees") {
    val filter = new RotateAsciiImageFilter(-90)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('C', 'F', 'I'),
      Array('B', 'E', 'H'),
      Array('A', 'D', 'G')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By -180 degrees") {
    val filter = new RotateAsciiImageFilter(-180)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('I', 'H', 'G'),
      Array('F', 'E', 'D'),
      Array('C', 'B', 'A')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("Unsupported rotation degree") {
    val filter = new RotateAsciiImageFilter(45)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    assertThrows[Exception] {
      filter.filter(inputImage)
    }
  }

}
