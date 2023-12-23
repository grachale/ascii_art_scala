package models.images

trait Image {

  /**
   * Returns width of image
   *
   * @return width of image
   */
  def width(): Int

  /**
   * Returns height of image
   *
   * @return height of image
   */
  def height(): Int

}
