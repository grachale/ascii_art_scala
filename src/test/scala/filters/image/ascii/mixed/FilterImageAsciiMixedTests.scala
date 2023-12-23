package filters.image.ascii.mixed

import filters.image.ascii.specific.{FlipAsciiImageFilter, RotateAsciiImageFilter, ScaleAsciiImageFilter}
import models.images.specific.AsciiImage

import org.scalatest.FunSuite

class FilterImageAsciiMixedTests extends FunSuite {

  test("Rotate 180, rotate 180, scale 1") {
    val filter1 = new RotateAsciiImageFilter(180)
    val filter2 = new RotateAsciiImageFilter(180)
    val filter3 = new ScaleAsciiImageFilter(1)

    val mixedFilter = new FilterImageAsciiMixed(Seq(filter1, filter2, filter3))

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    assert(mixedFilter.filter(inputImage) == inputImage)
  }

  test("Flip x, flip x, rotate 90, rotate -90, scale 1") {
    val filter1 = new FlipAsciiImageFilter('x')
    val filter2 = new RotateAsciiImageFilter(90)
    val filter3 = new FlipAsciiImageFilter('x')
    val filter4 = new RotateAsciiImageFilter(-90)
    val filter5 = new ScaleAsciiImageFilter(1)

    val mixedFilter = new FilterImageAsciiMixed(Seq(filter1, filter3, filter2, filter4, filter5))

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    assert(mixedFilter.filter(inputImage) == inputImage)
  }

  test("Flip y, flip y, rotate 360, rotate 0, scale 1") {
    val filter1 = new FlipAsciiImageFilter('y')
    val filter2 = new RotateAsciiImageFilter(360)
    val filter3 = new FlipAsciiImageFilter('y')
    val filter4 = new RotateAsciiImageFilter(0)
    val filter5 = new ScaleAsciiImageFilter(1)

    val mixedFilter = new FilterImageAsciiMixed(Seq(filter1, filter3, filter2, filter4, filter5))

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    assert(mixedFilter.filter(inputImage) == inputImage)
  }

  test("Flip x, flip x, rotate -270, rotate 270, scale 0.25, scale 4") {
    val filter1 = new FlipAsciiImageFilter('x')
    val filter2 = new RotateAsciiImageFilter(-270)
    val filter3 = new FlipAsciiImageFilter('x')
    val filter4 = new RotateAsciiImageFilter(270)
    val filter5 = new ScaleAsciiImageFilter(0.25)
    val filter6 = new ScaleAsciiImageFilter(4)

    val mixedFilter = new FilterImageAsciiMixed(Seq(filter1, filter3, filter2, filter4, filter5, filter6))

    val inputImage = AsciiImage(Array(
      Array('A', 'B', 'C', 'D'),
      Array('E', 'F', 'G', 'H'),
      Array('I', 'J', 'K', 'L'),
      Array('M', 'N', 'O', 'P')
    ))

    val expectedImage = AsciiImage(Array(
      Array('F', 'F', 'H', 'H'),
      Array('F', 'F', 'H', 'H'),
      Array('N', 'N', 'P', 'P'),
      Array('N', 'N', 'P', 'P')
    ))

    assert(mixedFilter.filter(inputImage) == expectedImage)
  }

}
