import scala.io.StdIn

object DesignerPdfViewer {

  def designerPdfViewer(h: Array[Int], word: String) = {
    val alphabets = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
      'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
      'u', 'v', 'w', 'x', 'y', 'z')

    val maxEle = word.map(c => h.zip(alphabets).find(t => t._2 == c).getOrElse((0, ' '))._1).max
    maxEle * word.length
  }


  def main(args: Array[String]): Unit = {

    val h = scala.io.StdIn.readLine.split(" ").map(_.trim.toInt)
    val word = scala.io.StdIn.readLine

    val result = designerPdfViewer(h, word)

    println(result)

  }
}
