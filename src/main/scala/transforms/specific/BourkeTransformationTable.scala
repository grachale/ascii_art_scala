package transforms.specific

import transforms.TransformationTable

class BourkeTransformationTable extends TransformationTable {

  /**
   * Takes pixel value (0-255) and returns corresponded Char
   *
   * @param value pixel value (0-255)
   * @return corresponded Char
   */
  override def transform(value: Int): Char = {

      // "Standard" character ramp written by Paul Bourke
      val conversionTable = Array(
        '$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*',
        'o', 'a', 'h', 'k', 'b', 'd', 'p', 'q', 'w', 'm', 'Z', 'O',
        '0', 'Q', 'L', 'C', 'J', 'U', 'Y', 'X', 'z', 'c', 'v', 'u',
        'n', 'x', 'r', 'j', 'f', 't', '/', '\\', '|', '(', ')', '1',
        '{', '}', '[', ']', '?', '-', '_', '+', '~', '<', '>', 'i',
        '!', 'l', 'I', ';', ':', ',', '"', '^', '`', '\'', '.', ' '
      )

      var checkedValue = value
      if (checkedValue > 255)
        checkedValue = 255 // assuming values above 255 are treated as 255
      else if (checkedValue < 0)
        checkedValue = 0  // assuming values below 0 are treated as 0

      val index = ((checkedValue.toDouble / 255) * (conversionTable.length - 1)).round.toInt

      conversionTable(index)
      }

}
