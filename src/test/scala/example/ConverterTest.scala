package example

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks

class ConverterTest extends AnyFunSuite with TableDrivenPropertyChecks {

  val singleMinutesExamples = Table(
    ("minutes", "representation"),
    (0, "0000"),
    (59, "YYYY"),
    (32, "YY00"),
    (34, "YYYY"),
    (35, "0000")
  )

  forAll(singleMinutesExamples) { (input, expected) =>
    test(s"single minutes row for input: $input") {
      val actual = Converter.convert(input)
      assert(actual == expected)
    }
  }

}
