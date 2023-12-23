package parsers

trait ArgumentParser {

  /**
   * Parses array of arguments and returns something.
   *
   * @param args Array of string arguments, which must be parsed
   * @return something
   */
  def parse(args: Array[String]): Any

}
