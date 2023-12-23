package transforms

trait TransformationTable {

  /**
   * Takes pixel value (0-255) and returns corresponded Char
   *
   * @param value pixel value (0-255)
   * @return corresponded Char
   */
  def transform(value: Int): Char

}
