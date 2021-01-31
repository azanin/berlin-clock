package example

object BerlinClockApp extends App {}

object Converter {

  def convert(minutes: Int): String = {
    val rest = minutes % 5
    "Y".repeat(rest) + "0".repeat(4 - rest)
  }
}
