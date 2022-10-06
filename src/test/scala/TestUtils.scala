
package cl.uchile.dcc.poke

import org.scalacheck.Gen

object TestUtils {
  val smallIntGenerator: Gen[Int] = for (n <- Gen.choose(1, 1000)) yield n
  val largeIntGenerator: Gen[Int] = for (n <- Gen.choose(1, 1000000)) yield n
}
