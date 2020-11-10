import java.text.SimpleDateFormat
import java.util.{Date, TimeZone}

object FactorsListBWTwoSets {

  def gcd(a: Long, b: Long): Long = {
    b match {
      case 0 => a
      case _ => gcd(b, a%b)
    }
  }

 def gcd(array: Array[Int]): Long = {
   array.foldLeft(0.toLong)((a,e) => gcd(a, e.toLong))
 }

  def lcm(a: Long, b: Long): Long = {
    a*b/gcd(a, b)
  }

  def lcm(array: Array[Int]): Long = {
    array.foldLeft(1.toLong)((a,e) => lcm(a,e.toLong))
  }

  def conditionMatched = (hcfArr2: Int, product: Int) => product == hcfArr2

  def factorsList(hcfArr2: Long, lcmArr1: Long) = {
    println("hcfArr2: "+hcfArr2+" lcmArr1: "+lcmArr1)
    if(lcmArr1 <= hcfArr2) {
      def iterate(status: Boolean, res: List[Long], index: Int): List[Long] = {
        if(status) res
        else {
          val no = index * lcmArr1
          iterate(no == hcfArr2, res :+ no, index + 1)
        }
      }
      iterate(false, List(), 1)
    }
    else List()
  }

  def factors(arr1: Array[Int], arr2: Array[Int]) = {
    val list = factorsList(gcd(arr2), lcm(arr1))
    println("list--"+list)
    if(list.isEmpty) 0
    else
      list.count(e => {
        arr2.map(arr2e => arr2e % e == 0).count(_ == true) == arr2.length
      })
  }





  def main(args: Array[String]): Unit = {
//    val arr =  StdIn.readLine.split(" ").map(_.trim.toInt)

//    val value = 1.4142135623730951
//    val res = ((value * 1000000).round / 1000000.toDouble)
//    println("--"+ factors(Array( 2), Array(20, 30, 12)) )
    println(new SimpleDateFormat("HH:mm:ss.SSS").setTimeZone(TimeZone.getTimeZone("UTC")))
    println("--"+ factors(Array( 100, 99, 98, 97, 96, 95, 94, 93, 92, 91), Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) )
    println(new SimpleDateFormat("YYYYMMdd_HHmmss").format(new Date))
  }
}








