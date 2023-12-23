package exporters.text

import java.io.OutputStream

class StreamTextExporter(outputStream: OutputStream) extends TextExporter {

  // indicates whether the stream is closed or not
  private var closed = false

  /**
   * Exports text into outputStream
   *
   * @param item The text to export
   */
  override def export(item: String): Unit = {
    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(item.getBytes("UTF-8"))
    outputStream.flush()
  }

  /**
   * Closes stream.
   */
  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }


}
