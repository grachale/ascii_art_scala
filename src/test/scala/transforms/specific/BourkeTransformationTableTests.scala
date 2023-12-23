package transforms.specific

import org.scalatest.FunSuite

class BourkeTransformationTableTests extends FunSuite {

  test("Lower bound") {
    val table = new BourkeTransformationTable
    val result = table.transform(0)
    assert(result === '$')
  }

  test("Upper bound") {
    val table = new BourkeTransformationTable
    val result = table.transform(255)
    assert(result === ' ')
  }

  test("Middle value") {
    val table = new BourkeTransformationTable
    val result = table.transform(128)
    assert(result === 'x')
  }

  test("Regular value") {
    val table = new BourkeTransformationTable
    val result = table.transform(63)
    assert(result === 'q')
  }

  test("Out of range (below)") {
    val table = new BourkeTransformationTable
    val result = table.transform(-10)
    assert(result === '$') // assuming values below 0 are treated as 0
  }

  test("Out of range (above)") {
    val table = new BourkeTransformationTable
    val result = table.transform(300)
    assert(result === ' ') // assuming values above 255 are treated as 255
  }

}
