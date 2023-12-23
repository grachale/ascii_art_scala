package filters.image.ascii.specific

import filters.image.ascii.AsciiImageFilter
import models.images.specific.AsciiImage

class FlipAsciiImageFilter(val axis: Char) extends AsciiImageFilter {

  /**
   * Flip AsciiImage on “y” or “x” axes.
   *
   * @param item The AsciiImage to flip
   * @return The flipped AsciiImage
   */
  override def filter(item: AsciiImage): AsciiImage = {

    var flipped: Array[Array[Char]] = Array.ofDim[Char](item.height(), item.width())

    axis match {
      case 'x' => flipped = item.image.reverse
      case 'y' => flipped = item.image.map(_.reverse)
      case _ => throw new Exception("Unsupported axis of flip.")
    }

    AsciiImage(flipped)
  }

}