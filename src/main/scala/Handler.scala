import conversions.images.specific.{AsciiImageConversion, GrayImageConversion, RGBImageConversion}
import exporters.text.TextExporter
import filters.image.ascii.mixed.FilterImageAsciiMixed
import loaders.image.ImageLoader
import models.images.Image
import models.images.specific.{AsciiImage, GrayImage, RGBImage}
import parsers.specific.{ImageFilterParser, ImageLoaderParser, ImageOutputParser, ImageTransformParser}
import transforms.TransformationTable
import transforms.specific.BourkeTransformationTable

class Handler() {

  /**
   * Process arguments and make an ascii art.
   *
   * @param args string arguments of app
   */
  def process(args: Array[String]): Unit = {

    // loading image
    val imageLoaderParser: ImageLoaderParser = new ImageLoaderParser
    val loader: Option[ImageLoader] = imageLoaderParser.parse(args)

    var image: Image = loader match {
      case Some(loader) => loader.load()
      case _ => throw new Exception("Unspecified image file.")
    }

    // transforms image into ascii one

    // #1 calculating gray scale value
    var imageGray: GrayImage = image match {
      case s: GrayImage => s
      case s: RGBImage => {
        val rgbImageConversion: RGBImageConversion = new RGBImageConversion()
        rgbImageConversion.toGrey(s)
      }
      case _ => throw new Exception("Bad image type")
    }

    // #2 transformation to ascii symbols
    val imageTransformParser: ImageTransformParser = new ImageTransformParser
    var transformationTable: Option[TransformationTable] = imageTransformParser.parse(args)

    val grayImageConversion: GrayImageConversion = new GrayImageConversion()

    var imageAscii: AsciiImage = transformationTable match {
      case Some(s) => grayImageConversion.toAscii(imageGray, s)
      // default "bourke_standard" table
      case _ => {
        val transformTableBourke: BourkeTransformationTable = new BourkeTransformationTable
        grayImageConversion.toAscii(imageGray, transformTableBourke)
      }
    }

    // filters
    val imageFilterParser: ImageFilterParser = new ImageFilterParser
    val mixedFilters: FilterImageAsciiMixed = imageFilterParser.parse(args)
    imageAscii = mixedFilters.filter(imageAscii)

    // output image
    val imageOutputParser: ImageOutputParser = new ImageOutputParser
    val arrayOfExporters: Array[TextExporter] = imageOutputParser.parse(args)

    val asciiImageConversion: AsciiImageConversion = new AsciiImageConversion
    arrayOfExporters.foreach(exporter => exporter.export(asciiImageConversion.toString(imageAscii)))

  }

}
