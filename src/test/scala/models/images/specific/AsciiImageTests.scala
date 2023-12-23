package models.images.specific

import org.scalatest.FunSuite

class AsciiImageTests extends FunSuite {

  test("Values") {
    var array2d = Array(Array('a', '$'), Array('0', '*'))
    var asciiImage = AsciiImage(array2d)

    assert(asciiImage.image(0)(0) == 'a')
    assert(asciiImage.image(0)(1) == '$')
    assert(asciiImage.image(1)(0) == '0')
    assert(asciiImage.image(1)(1) == '*')
  }

  test("Dimensions 2x2") {
    var array2d = Array(Array('a', '$'), Array('0', '*'))
    var asciiImage = AsciiImage(array2d)

    assert(asciiImage.width() == 2)
    assert(asciiImage.height() == 2)
  }

  test("Dimensions 3x2") {
    var array2d = Array(Array('a', '$'), Array('0', '*'), Array('0', '*'))
    var asciiImage = AsciiImage(array2d)

    assert(asciiImage.width() == 2)
    assert(asciiImage.height() == 3)
  }

  test("Dimensions 2x3") {
    var array2d = Array(Array('a', '$', 'f'), Array('0', '*', '&'))
    var asciiImage = AsciiImage(array2d)

    assert(asciiImage.width() == 3)
    assert(asciiImage.height() == 2)
  }

  test("Dimensions 3x3") {
    var array2d = Array(Array('a', '$', 'f'), Array('0', '*', '&'), Array('0', '*', '&'))
    var asciiImage = AsciiImage(array2d)

    assert(asciiImage.width() == 3)
    assert(asciiImage.height() == 3)
  }


}

