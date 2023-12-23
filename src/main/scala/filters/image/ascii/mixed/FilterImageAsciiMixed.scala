package filters.image.ascii.mixed

import filters.image.ascii.AsciiImageFilter
import models.images.specific.AsciiImage

class FilterImageAsciiMixed(val filters: Seq[AsciiImageFilter]) extends AsciiImageFilter {
  /**
   * Iterates over filters and filter item using all of them
   *
   * @param item The AsciiImage to filter
   * @return The filtered AsciiImage
   */
  override def filter(item: AsciiImage): AsciiImage =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
