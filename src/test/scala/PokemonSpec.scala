package cl.uchile.dcc.poke

import org.scalatest.matchers.must.Matchers.not
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, theSameInstanceAs}

class PokemonSpec extends AbstractPokemonSpec {
  var salandit: Pokemon = _
  var scolipede: Pokemon = _

  before {
    salandit = new Pokemon("Salandit", 48, 44)
    scolipede = new Pokemon("Scolipede", 60, 100)
  }

  test("Two Pokémon with the same parameters should be equal") {
    val salandit2 = new Pokemon("Salandit", 48, 44)
    salandit should not be theSameInstanceAs(salandit2)
    salandit shouldBe salandit2
    val scolipede2 = new Pokemon("Scolipede", 60, 100)
    scolipede should not be theSameInstanceAs(scolipede2)
    scolipede shouldBe scolipede2
  }

  test("Two Pokémon with different parameters should not be equal") {
    salandit should not be theSameInstanceAs(scolipede)
    salandit should not equal scolipede
  }
}
