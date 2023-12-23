package models.pixels.specific

import models.pixels.Pixel

case class GrayPixel(value: Int) extends Pixel {

  /**
   * Custom equals method for GrayPixel
   *
   * @param obj Object to compare
   * @return True if the objects are equal, false otherwise
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: GrayPixel =>
        this.value == other.value
      case _ => false
    }
  }

  /**
   * Custom hash code method for GrayPixel
   *
   * @return Hash code
   */
  override def hashCode(): Int = {
    value.hashCode()
  }

}
