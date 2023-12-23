package transforms.specific

import org.scalatest.FunSuite

class CustomTransformationTableTests extends FunSuite {

  test("Lower bound") {
    val symbols = Array('$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*')
    val table = new CustomTransformationTable(symbols)
    val result = table.transform(0)
    assert(result === '$')
  }

  test("Upper bound") {
    val symbols = Array('$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*')
    val table = new CustomTransformationTable(symbols)
    val result = table.transform(255)
    assert(result === '*')
  }

  test("Middle value") {
    val symbols = Array('$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*')
    val table = new CustomTransformationTable(symbols)
    val result = table.transform(128)
    assert(result === '&')
  }

  test("Decimal value") {
    val symbols = Array('$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*')
    val table = new CustomTransformationTable(symbols)
    val result = table.transform(63)
    assert(result === 'B')
  }

  test("Out of range (below)") {
    val symbols = Array('$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*')
    val table = new CustomTransformationTable(symbols)
    val result = table.transform(-10)
    assert(result === '$') // Assuming values below 0 are treated as 0
  }

  test("Out of range (above)") {
    val symbols = Array('$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*')
    val table = new CustomTransformationTable(symbols)
    val result = table.transform(300)
    assert(result === '*') // Assuming values above 255 are treated as 255
  }

}
