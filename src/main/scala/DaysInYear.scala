object DaysInYear {
  trait Month{
    def n: String
    def days: Int
  }
  case object Jan extends Month {
    override def n: String = "01"
    override def days: Int = 31
  }
  case class Feb(febDays: Int) extends Month {
    override def n: String = "02"
    override def days: Int = febDays
  }
  case object March extends Month {
    override def n: String = "03"
    override def days: Int = 31
  }
  case object Apr extends Month {
    override def n: String = "04"
    override def days: Int = 30
  }
  case object May extends Month {
    override def n: String = "05"
    override def days: Int = 31
  }
  case object June extends Month {
    override def n: String = "06"
    override def days: Int = 30
  }
  case object July extends Month {
    override def n: String = "07"
    override def days: Int = 31
  }
  case object Aug extends Month {
    override def n: String = "08"
    override def days: Int = 31
  }
  case object Sept extends Month {
    override def n: String = "09"
    override def days: Int = 30
  }
  case object Oct extends Month {
    override def n: String = "10"
    override def days: Int = 31
  }
  case object Nov extends Month {
    override def n: String = "11"
    override def days: Int = 30
  }
  case object Dec extends Month {
    override def n: String = "12"
    override def days: Int = 31
  }
  object Month{
    def months(febDays: Int) = List(Jan, Feb(febDays), March, Apr, May, June, July, Aug, Sept, Oct, Nov, Dec)
  }

  def isLeapYear(year: Int, cal: String) = {
    cal match {
      case "Julian" => year%4 == 0
      case _ => (year%400 == 0) || (year%4 == 0 && year%100 != 0 )
    }
  }

  def calculateDays(febDays: Int, year: Int) = {
    val days = 256
    def iterate(status: Boolean, remainMonths: List[Month], sum: Int, date: String): String= {
      if(status) date
      else{
        val daysInMonth = remainMonths.head.days
        if(days-sum > daysInMonth ) {
          val sumofDays = sum + daysInMonth
          iterate(false, remainMonths.tail, sumofDays, date )
        }
        else{
          val daysInMonth = remainMonths.head.days
          val day = days-sum
          iterate(true, List(), sum, s"${day}.${remainMonths.head.n}.${year}")
        }
      }
    }
    iterate(false, Month.months(febDays), 0, "")
  }

  def dayOfProgrammer(year: Int): String = {
    if(year >= 1700 &&  year <= 1917) {
      val febDays = if(isLeapYear(year, "Julian")) 29 else 28
      calculateDays(febDays, year)
    }
    else if(year == 1918){
      val febDays = if(isLeapYear(year, "G")) 29 else 28
      calculateDays(febDays-13, year)
    }
    else {
      val febDays = if(isLeapYear(year, "G")) 29 else 28
      println(febDays)
      calculateDays(febDays, year)
    }

  }
  def main(args: Array[String]): Unit = {
//    val n = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    val list = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    for(i <- 0 until n){
//      perfect(scala.io.StdIn.readInt())
//    }
    println(dayOfProgrammer(2100))
  }
}
