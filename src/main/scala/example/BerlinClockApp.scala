package example

import java.time.LocalTime

object BerlinClockApp extends App {}

object Converter {
  val fiveHourRowSize      = 4
  val singleHourRowSize    = 4
  val fiveMinutesRowSize   = 11
  val singleMinutesRowSize = 4

  def convertSeconds(seconds: Int) = {
    val nLedOn = seconds % 2
    build(1 - nLedOn, "Y") + build(nLedOn, "O")
  }

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

  def convertFiveHours(hours: Int) = {
    val nLedOn = hours / 5
    build(nLedOn, "R") + build(fiveHourRowSize - nLedOn, "O")
  }

  def convertTime(input: LocalTime) =
    convertSeconds(input.getSecond) +
      convertFiveHours(input.getHour) +
      convertSingleHour(input.getHour) +
      convertFiveMinute(input.getMinute) +
      convertSingleMinute(input.getMinute)

  private def build(lenght: Int, pattern: String): String =
    pattern.repeat(lenght)
}
