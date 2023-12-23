package loaders

trait Loader[T] {

  /**
   * Load something
   *
   * @return something
   */
  def load(): T

}
