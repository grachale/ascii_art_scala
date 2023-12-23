package models.images.specific

import models.images.Image
import models.pixels.specific.RGBPixel

import java.util.Arrays

case class RGBImage(image: Array[Array[RGBPixel]]) extends Image {

  /**
   * Returns height of RGBImage
   *
   * @return height of RGBImage
   */
  override def height(): Int = image.length

  /**
   * Returns width of RGBImage
   *
   * @return width of RGBImage
   */
  override def width(): Int = image(0).length

  /**
   * Custom equals method for RGBImage
   *
   * @param obj Object to compare
   * @return True if the objects are equal, false otherwise
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: RGBImage =>
        Arrays.deepEquals(
          this.image.asInstanceOf[Array[AnyRef]],
          other.image.asInstanceOf[Array[AnyRef]]
        )
      case _ => false
    }
  }

  /**
   * Custom hash code method for RGBImage
   *
   * @return Hash code
   */
  override def hashCode(): Int = {
    Arrays.deepHashCode(image.asInstanceOf[Array[AnyRef]])
  }
}
