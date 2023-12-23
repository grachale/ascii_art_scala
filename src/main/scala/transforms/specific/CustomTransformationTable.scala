package transforms.specific

import transforms.TransformationTable

class CustomTransformationTable(val symbols: Array[Char]) extends TransformationTable {

  /**
   * Takes pixel value (0-255) and returns corresponded Char from symbols
   *
   * @param value pixel value (0-255)
   * @return corresponded Char
   */
  override def transform(value: Int): Char = {

    var checkedValue = value
    if (checkedValue > 255)
      checkedValue = 255 // assuming values above 255 are treated as 255
    else if (checkedValue < 0)
      checkedValue = 0 // assuming values below 0 are treated as 0

      val index = ((checkedValue.toDouble / 255) * (symbols.length - 1)).round.toInt
      symbols(index)
  }

}
