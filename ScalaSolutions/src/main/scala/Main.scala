import java.io.File

object Main {

  /**
   * Prints the list of solutions
   * @param args
   */
  def main(args: Array[String]): Unit = {
    println("Scala Leetcode Solutions List:")
    getListOfSubDirectories(System.getProperty("user.dir") + "/src/main/scala").foreach(println)
  }

  def getListOfSubDirectories(directoryName: String): Array[String] = {
    (new File(directoryName))
      .listFiles
      .filter(_.isDirectory)
      .map(_.getName)
  }
}
