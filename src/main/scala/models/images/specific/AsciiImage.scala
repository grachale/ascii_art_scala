package models.images.specific

import models.images.Image

import java.util.Arrays

case class AsciiImage(image: Array[Array[Char]]) extends Image {

  /**
   * Returns height of AsciiImage
   *
   * @return height of AsciiImage
   */
  override def height(): Int = image.length

  /**
   * Returns width of AsciiImage
   *
   * @return width of AsciiImage
   */
  override def width(): Int = image(0).length

  /**
   * Custom equals method for AsciiImage
   *
   * @param obj Object to compare
   * @return True if the objects are equal, false otherwise
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: AsciiImage =>
        Arrays.deepEquals(this.image.asInstanceOf[Array[AnyRef]], other.image.asInstanceOf[Array[AnyRef]])
      case _ => false
    }
  }

  /**
   * Custom hash code method for AsciiImage
   *
   * @return Hash code
   */
  override def hashCode(): Int = {
    Arrays.deepHashCode(image.asInstanceOf[Array[AnyRef]])
  }
}

