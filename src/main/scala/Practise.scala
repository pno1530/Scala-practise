object Practise {

  def perfect(int: Int) = {
    var factors = List[Int]()
    for(i <- 1 to int/2){
      if(int % i == 0) factors = factors :+ i
    }
    if(factors.sum == int) println("YES")
    else println("NO")
  }

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    for(i <- 0 until n){
      perfect(scala.io.StdIn.readInt())
    }
  }
}
