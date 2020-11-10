

object thunderCloud {

  def jumpingOnClouds(c: Array[Int], k: Int): Int = {
    def iterate(remain: List[Int], res: Int): Int = {
      println(s"${remain}, res: $res")
      if (remain == Nil) {
        if(c(0) == 1) res - 3
        else res - 1
      }
      else if(remain.head == 1) iterate( remain.drop(k), res - k - 2)
      else iterate(remain.drop(k), res - k)
    }
    iterate(c.toList.drop(k), 100)
  }



  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c, k)

    println(result)


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