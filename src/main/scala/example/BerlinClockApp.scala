package example

object BerlinClockApp extends App {}

object Converter {

  val singleHourRowSize    = 4
  val fiveMinutesRowSize   = 11
  val singleMinutesRowSize = 4

  def convertFiveMinute(minutes: Int): String = {
    val nLedOn = minutes / 5
    build(nLedOn / 3, "YYR") + build(nLedOn % 3, "Y") + build(fiveMinutesRowSize - nLedOn, "O")
  }

  def convertSingleHour(hours: Int): String = {
    val nLedOn = hours % 5
    build(nLedOn, "R") + build(singleHourRowSize - nLedOn, "O")
  }

  def convertSingleMinute(minutes: Int): String = {
    val nLedOn = minutes % 5
    build(nLedOn, "Y") + "O".repeat(singleMinutesRowSize - nLedOn)
  }

  private def build(lenght: Int, pattern: String): String =
    pattern.repeat(lenght)
}
