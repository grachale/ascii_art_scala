package models.images.specific

import models.images.Image
import models.pixels.specific.GrayPixel

import java.util.Arrays

case class GrayImage(image: Array[Array[GrayPixel]]) extends Image {

  /**
   * Returns height of GrayImage
   *
   * @return height of GrayImage
   */
  override def height(): Int = image.length

  /**
   * Returns width of GrayImage
   *
   * @return width of GrayImage
   */
  override def width(): Int = image(0).length

  /**
   * Custom equals method for GrayImage
   *
   * @param obj Object to compare
   * @return True if the objects are equal, false otherwise
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: GrayImage =>
        Arrays.deepEquals(
          this.image.asInstanceOf[Array[AnyRef]],
          other.image.asInstanceOf[Array[AnyRef]]
        )
      case _ => false
    }
  }

  /**
   * Custom hash code method for GrayImage
   *
   * @return Hash code
   */
  override def hashCode(): Int = {
    Arrays.deepHashCode(image.asInstanceOf[Array[AnyRef]])
  }

}
