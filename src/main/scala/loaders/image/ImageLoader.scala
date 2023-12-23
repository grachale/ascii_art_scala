package loaders.image

import loaders.Loader
import models.images.Image

trait ImageLoader extends Loader[Image]{

  /**
   * Load an Image
   *
   * @return Image
   */
  def load(): Image

}
