

object RepeatedString {

  def repeatedString(s: String, n: Long) = {
    val noOfTimes = (n/s.size)
    println(noOfTimes)
    val remain = n - (s.size * noOfTimes)
    println(remain)
    def iterate(string: String, n: Long): String = {
      n match {
        case 0 => string
        case _ => iterate(string+s, n-1)
      }
    }
    val str = iterate(s, noOfTimes-1)
    println(str)

    println(str + s.take(remain.toInt))
    (str + s.take(remain.toInt)).count(_ == 'a')
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)


    println(result)
  }
}
