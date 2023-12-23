package filters.image.ascii.specific

import models.images.specific.AsciiImage

import org.scalatest.FunSuite

class FlipAsciiImageFilterTests extends FunSuite {

  test("By x-axis (3x3)") {
    val filter = new FlipAsciiImageFilter('x')

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('G', 'H', 'I'),
      Array('D', 'E', 'F'),
      Array('A', 'B', 'C')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By y-axis (3x3)") {
    val filter = new FlipAsciiImageFilter('y')

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C'),
      Array('D', 'E', 'F'),
      Array('G', 'H', 'I')
    ))

    val expectedImage = AsciiImage(Array(
      Array('C', 'B', 'A'),
      Array('F', 'E', 'D'),
      Array('I', 'H', 'G')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By x-axis (2x2)") {
    val filter = new FlipAsciiImageFilter('x')

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('C', 'D')
    ))

    val expectedImage = AsciiImage(Array(
      Array('C', 'D'),
      Array('A', 'B')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("By y-axis (2x2)") {
    val filter = new FlipAsciiImageFilter('y')

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('C', 'D')
    ))

    val expectedImage = AsciiImage(Array(
      Array('B', 'A'),
      Array('D', 'C')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("Exception (z-axis)") {
    val filter = new FlipAsciiImageFilter('z')

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
