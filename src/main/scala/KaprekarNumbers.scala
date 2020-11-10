import scala.collection.immutable.List

object KaprekarNumbers {

  def istheFunction(str: String) : Boolean = {
    val list = str.split("").toList.map(_.toInt)
    def iterate( res: Boolean, count : Int): Boolean = {
      if(count < 9 && list.count(_ == count) == count) true
      else if(count > 9 && !(list.count(_ == count) == count)) false
      else iterate(false, count +1 )
    }
    iterate(false, 1)
  }


  def main(args: Array[String]) {
    println(istheFunction("23346"))
  }

}
