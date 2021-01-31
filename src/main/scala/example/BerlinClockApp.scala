package example

object BerlinClockApp extends App {}

object Converter {

  val panelFiveMinutesSize   = 11
  val panelSingleMinutesSize = 4

  def convertFiveMinute(minutes: Int): String = {
    val nLedOn = minutes / 5
    build(nLedOn / 3, "YYR") + build(nLedOn % 3, "Y") + build(panelFiveMinutesSize - nLedOn, "O")
  }

  private def build(lenght: Int, pattern: String): String =
    pattern.repeat(lenght)

  def convertSingleMinute(minutes: Int): String = {
    val nLedOn = minutes % 5
    build(nLedOn, "Y") + "O".repeat(panelSingleMinutesSize - nLedOn)
  }
}
