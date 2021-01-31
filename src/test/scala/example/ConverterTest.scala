package example

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks

class ConverterTest extends AnyFunSuite with TableDrivenPropertyChecks {

  val singleMinutesExamples = Table(
    ("minutes", "representation"),
    (0, "OOOO"),
    (59, "YYYY"),
    (32, "YYOO"),
    (34, "YYYY"),
    (35, "OOOO")
  )

  val fiveMinutesExamples = Table(
    ("minutes", "representation"),
    (0, "OOOOOOOOOOO"),
    (59, "YYRYYRYYRYY"),
    (4, "OOOOOOOOOOO"),
    (23, "YYRYOOOOOOO"),
    (35, "YYRYYRYOOOO")
  )

  val singleHourExamples = Table(
    ("hours", "representation"),
    (0, "OOOO"),
    (23, "RRRO"),
    (2, "RROO"),
    (8, "RRRO"),
    (14, "RRRR")
  )

  forAll(singleMinutesExamples) { (input, expected) =>
    test(s"single minutes row for input: $input") {
      val actual = Converter.convertSingleMinute(input)
      assert(actual == expected)
    }
  }

  forAll(fiveMinutesExamples) { (input, expected) =>
    test(s"five minutes row for input: $input") {
      val actual = Converter.convertFiveMinute(input)
      assert(actual == expected)
    }
  }

  forAll(singleHourExamples) { (input, expected) =>
    test(s"single hours row for input: $input") {
      val actual = Converter.convertSingleHour(input)
      assert(actual == expected)
    }
  }

}
