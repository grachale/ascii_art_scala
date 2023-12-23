package exporters.text

import java.io.{File, FileOutputStream}

class FileTextExporter(val path: String) extends StreamTextExporter(new FileOutputStream(new File(path))) {

}
