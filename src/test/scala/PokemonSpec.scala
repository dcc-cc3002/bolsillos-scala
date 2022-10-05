package cl.uchile.dcc.poke

import org.scalatest.matchers.must.Matchers.not
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, theSameInstanceAs}

class PokemonSpec extends AbstractPokemonSpec {
  private val salanditName = "Salandit"
  private val salanditHp = 48
  private val salanditStr = 44
  private val scolipedeName = "Scolipede"
  private val scolipedeHp = 60
  private val scolipedeStr = 100

  private var salandit: Pokemon = _
  private var scolipede: Pokemon = _

  before {
    salandit = new Pokemon(salanditName, salanditHp, salanditStr)
    scolipede = new Pokemon(scolipedeName, scolipedeHp, scolipedeStr)
  }

  test("Two Pokémon with the same parameters should be equal") {
    val salandit2 = new Pokemon(salanditName, salanditHp, salanditStr)
    salandit should not be theSameInstanceAs(salandit2)
    salandit shouldBe salandit2
    val scolipede2 = new Pokemon(scolipedeName, scolipedeHp, scolipedeStr)
    scolipede should not be theSameInstanceAs(scolipede2)
    scolipede shouldBe scolipede2
  }

  test("Two Pokémon with different parameters should not be equal") {
    salandit should not be theSameInstanceAs(scolipede)
    salandit should not equal scolipede
  }


  test("A Pokémon can attack another Pokémon") {
    salandit.attack(scolipede)
    scolipede.currentHp shouldBe scolipedeHp - salanditStr / 10
  }

  test("A Pokémon can be KO") {
    salandit.isKo shouldBe false
    salandit.currentHp = 0
    salandit.isKo shouldBe true
  }

  test("A Pokémon can be KOd by an attack") {
    salandit.isKo shouldBe false
    1 to 5 foreach {
      _ => scolipede.attack(salandit)
    }
    salandit.isKo shouldBe true
  }
}
