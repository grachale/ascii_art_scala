package models.pixels.specific

import models.pixels.Pixel

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {

  /**
   * Custom equals method for RGBPixel
   *
   * @param obj Object to compare
   * @return True if the objects are equal, false otherwise
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: RGBPixel =>
        this.red == other.red && this.green == other.green && this.blue == other.blue
      case _ => false
    }
  }

  /**
   * Custom hash code method for RGBPixel
   *
   * @return Hash code
   */
  override def hashCode(): Int = {
    red.hashCode() + green.hashCode() + blue.hashCode()
  }

}
