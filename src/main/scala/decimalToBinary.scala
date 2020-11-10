import org.com.ct.service.interpreter.Common.Input

object decimalToBinary {

  def decimalToBinary(num: Int, res: List[Int]): List[Int] = {
    val q = num/2
    val r = num%2
    if(q == 1)  (q :: r :: res)
    else decimalToBinary(q, r +: res )
  }

  def findBits(num1: Int, num2: Int)= {
    (num1 | num2) - (num1 & num2)
  }

  def converttobinary(n:Int, bin:List[Int] = List[Int]()):String = {
    if(n/2 == 1) (1:: (n % 2) :: bin).mkString(" ")
    else {
      val r = n % 2;
      val q = n / 2;
      converttobinary(q, r::bin)
    }
  }

//  def main(args: Array[String]): Unit = {
//
//
//    val result = decimalToBinary(156, List())
//
//    println(result)
//    val l = List[Int](65, 80)
//    println(l.map(converttobinary(_)))
//
//  }

  def xor(array: List[Int]) = {
    var ar= 1
    for(i <- 0 to array.length-1 ){
      ar = ar ^ array(i)
    }
    ar
  }

  def main(args: Array[String]): Unit = {

    val l = List(4, 7, 18, 16, 14)

    def iterate(input: List[Int], res: Int): Int = {
      input match {
        case Nil => res
        case _ => {
          iterate(input.filter(_ != input.max), xor(l))
      }
      }
    }
    println(iterate(l, 0))

  }
  scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
}
