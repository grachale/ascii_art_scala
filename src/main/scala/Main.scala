object App {
  def main(args: Array[String]): Unit = {

    val handler = new Handler()

    try {
      handler.process(args)
    } catch {
      case e: Exception => println("Error in app: " + e.getMessage)
    }
  }
}