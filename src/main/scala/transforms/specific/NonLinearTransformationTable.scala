package transforms.specific

import transforms.TransformationTable

class NonLinearTransformationTable extends TransformationTable {

  /**
   * Takes pixel value (0-255) and returns corresponded Char
   *
   * @param value pixel value (0-255)
   * @return corresponded Char
   */
  override def transform(value: Int): Char = {

      value match {
        case num if num <= 180 => '@'
        case num if num <= 220 => '8'
        case num if num <= 240 => 'O'
        case _ => '.'
      }
  }

}
