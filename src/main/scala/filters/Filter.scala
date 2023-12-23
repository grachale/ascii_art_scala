package filters

trait Filter[T] {

  /**
   * Filters an item
   *
   * @param item The item to filter
   * @return The filtered item
   */
  def filter(item: T) : T

}
