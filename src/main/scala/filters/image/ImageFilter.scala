package filters.image

import filters.Filter
import models.images.Image

trait ImageFilter[T <: Image] extends Filter[T] {

}
