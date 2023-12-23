package filters.image.ascii.specific

import org.scalatest.FunSuite
import models.images.specific.AsciiImage

class ScaleAsciiImageFilterTests extends FunSuite {

  test("Scale by 0.25 (4x4 image)") {
    val filter = new ScaleAsciiImageFilter(0.25)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    val expectedImage = AsciiImage(Array(
      Array('F', 'H'),
      Array('N', 'P')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("Scale by 1 (4x4 image)") {
    val filter = new ScaleAsciiImageFilter(1)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    assert(filter.filter(inputImage) == inputImage)
  }

  test("Scale by 4 (4x4 image)") {
    val filter = new ScaleAsciiImageFilter(4)

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    val expectedImage = AsciiImage(Array(
      Array('A', 'A', 'B', 'B', 'C', 'C', 'D', 'D'),
      Array('A', 'A', 'B', 'B', 'C', 'C', 'D', 'D'),
      Array('E', 'E', 'F', 'F', 'G', 'G', 'H', 'H'),
      Array('E', 'E', 'F', 'F', 'G', 'G', 'H', 'H'),
      Array('I', 'I', 'J', 'J', 'K', 'K', 'L', 'L'),
      Array('I', 'I', 'J', 'J', 'K', 'K', 'L', 'L'),
      Array('M', 'M', 'N', 'N', 'O', 'O', 'P', 'P'),
      Array('M', 'M', 'N', 'N', 'O', 'O', 'P', 'P')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("Scale by 0.25 (2x2 image)") {
    val filter = new ScaleAsciiImageFilter(0.25)

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('E', 'F'),

    ))

    val expectedImage = AsciiImage(Array(
      Array('F')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("Scale by 1 (2x2 image)") {
    val filter = new ScaleAsciiImageFilter(1)

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('E', 'F')
    ))

    assert(filter.filter(inputImage) == inputImage)
  }

  test("Scale by 4 (2x2 image)") {
    val filter = new ScaleAsciiImageFilter(4)

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('E', 'F')
    ))

    val expectedImage = AsciiImage(Array(
      Array('A', 'A', 'B', 'B'),
      Array('A', 'A', 'B', 'B'),
      Array('E', 'E', 'F', 'F'),
      Array('E', 'E', 'F', 'F')
    ))

    assert(filter.filter(inputImage) == expectedImage)
  }

  test("Unsupported scale value 1") {
    val filter = new ScaleAsciiImageFilter(10)

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('E', 'F')
    ))

    assertThrows[Exception] {
      filter.filter(inputImage)
    }
  }

  test("Unsupported scale value 2") {
    val filter = new ScaleAsciiImageFilter(0.5)

    val inputImage = AsciiImage(Array(
      Array('A', 'B'),
      Array('E', 'F')
    ))

    assertThrows[Exception] {
      filter.filter(inputImage)
    }
  }


}

