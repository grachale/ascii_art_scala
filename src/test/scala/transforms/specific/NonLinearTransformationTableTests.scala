package transforms.specific

import org.scalatest.FunSuite

class NonLinearTransformationTableTests extends FunSuite {

  test("Lower bound") {
    val table = new NonLinearTransformationTable
    val result = table.transform(0)
    assert(result === '@')
  }

  test("Mid-Lower bound") {
    val table = new NonLinearTransformationTable
    val result = table.transform(180)
    assert(result === '@')
  }

  test("Mid-Upper bound") {
    val table = new NonLinearTransformationTable
    val result = table.transform(220)
    assert(result === '8')
  }

  test("Upper bound") {
    val table = new NonLinearTransformationTable
    val result = table.transform(255)
    assert(result === '.')
  }

  test("Out of range (below)") {
    val table = new NonLinearTransformationTable
    val result = table.transform(-10)
    assert(result === '@') // Assuming values below 0 are treated as 0
  }

  test("Out of range (above)") {
    val table = new NonLinearTransformationTable
    val result = table.transform(300)
    assert(result === '.') // Assuming values above 255 are treated as 255
  }

}
