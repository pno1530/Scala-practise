

object FindDigits {

  def findDigits(n: Int) = {
      n.toString.foldLeft(0)((a, e) => {
        val num = e.toString.toInt
        if(num == 0) a
        else {
          if(n - (num * (n/num)) == 0) a +1
          else a
        }
      })

  }



  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val result = findDigits(n)

      println(result)
    }


  }





}

//object Solution {
//
//  def move (n : Int, k : Int, cs : Seq[Boolean], i : Int, e : Int) : Int = {
//    val newI = (i + k) % n
//    val newE = e - (if (cs(i)) 3 else 1)
//    if (newI == 0) newE
//    else move (n, k, cs, newI, newE)
//  }
//
//  def main(args: Array[String]) {
//    val sc = new java.util.Scanner (System.in);
//    val n = sc.nextInt();
//    val k = sc.nextInt();
//    var c = new Array[Boolean](n);
//    for(c_i <- 0 to n-1) {
//      c(c_i) = sc.nextInt() == 1;
//    }
//    val cs = c.toVector
//    println (move (n, k, cs, 0, 100))
//  }
//}