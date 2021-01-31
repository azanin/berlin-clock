package example

import java.time.LocalTime

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

  val fiveHourExamples = Table(
    ("hours", "representation"),
    (0, "OOOO"),
    (23, "RRRR"),
    (2, "OOOO"),
    (8, "ROOO"),
    (16, "RRRO")
  )

  val secondsExamples = Table(
    ("seconds", "representation"),
    (0, "Y"),
    (59, "O")
  )

  val timeExamples = Table(
    ("time", "representation"),
    (LocalTime.of(0, 0, 0), "YOOOOOOOOOOOOOOOOOOOOOOO"),
    (LocalTime.of(23, 59, 59), "ORRRRRRROYYRYYRYYRYYYYYY"),
    (LocalTime.of(16, 50, 6), "YRRROROOOYYRYYRYYRYOOOOO"),
    (LocalTime.of(11, 37, 1), "ORROOROOOYYRYYRYOOOOYYOO")
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

  forAll(fiveHourExamples) { (input, expected) =>
    test(s"five hours row for input: $input") {
      val actual = Converter.convertFiveHours(input)
      assert(actual == expected)
    }
  }

  forAll(secondsExamples) { (input, expected) =>
    test(s"seconds row for input: $input") {
      val actual = Converter.convertSeconds(input)
      assert(actual == expected)
    }
  }

  forAll(timeExamples) { (input, expected) =>
    test(s"time $input should be: $expected") {
      val actual = Converter.convertTime(input)
      assert(actual == expected)
    }

  }

}
