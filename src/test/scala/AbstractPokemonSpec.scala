package cl.uchile.dcc.poke

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

abstract class AbstractPokemonSpec
  extends AnyFunSuite
  with BeforeAndAfter
  with ScalaCheckPropertyChecks
