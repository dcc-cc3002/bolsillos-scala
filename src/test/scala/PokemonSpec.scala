package cl.uchile.dcc.poke

import TestUtils.{largeIntGenerator, smallIntGenerator}

import org.scalatest.matchers.must.Matchers.not
import org.scalatest.matchers.should.Matchers.{
  convertToAnyShouldWrapper,
  theSameInstanceAs
}

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
    forAll("name", smallIntGenerator, largeIntGenerator) {
      (name: String, hp: Int, str: Int) =>
        val pokemon1 = new Pokemon(name, hp, str)
        val pokemon2 = new Pokemon(name, hp, str)
        pokemon1 should not be theSameInstanceAs(pokemon2)
        pokemon1 shouldEqual pokemon2
    }
  }

  test("Two Pokémon with different names are not equal") {
    forAll(
      "name1",
      "name2",
      smallIntGenerator,
      largeIntGenerator
    ) { (name1: String, name2: String, hp: Int, str: Int) =>
      whenever(name1 != name2) {
        val pokemon1 = new Pokemon(name1, hp, str)
        val pokemon2 = new Pokemon(name2, hp, str)
        pokemon1 should not be pokemon2
      }
    }
  }

  test("A Pokémon can attack another Pokémon") {
    forAll(
      "name1",
      "name2",
      smallIntGenerator,
      smallIntGenerator,
      smallIntGenerator,
      smallIntGenerator
    ) {
      (
          name1: String,
          name2: String,
          hp1: Int,
          hp2: Int,
          str1: Int,
          str2: Int
      ) =>
        whenever(hp2 - str1 / 10 > 0) {
          val pokemon1 = new Pokemon(name1, hp1, str1)
          val pokemon2 = new Pokemon(name2, hp2, str2)
          pokemon1.attack(pokemon2)
          pokemon2._currentHp shouldBe (hp2 - str1 / 10)
        }
    }
  }

  test("A Pokémon can be KO") {
    forAll("name", smallIntGenerator, smallIntGenerator) {
      (name: String, hp: Int, str: Int) =>
        {
          val pokemon = new Pokemon(name, hp, str)
          pokemon.isKo shouldBe false
          pokemon._currentHp = 0
          pokemon.isKo shouldBe true
        }
    }
  }

  test("A Pokémon can be KOd by an attack") {
    forAll(
      "name1",
      "name2",
      smallIntGenerator,
      smallIntGenerator,
      largeIntGenerator,
      largeIntGenerator
    ) {
      (
          name1: String,
          name2: String,
          hp1: Int,
          hp2: Int,
          str1: Int,
          str2: Int
      ) =>
        whenever(hp2 - str1 / 10 <= 0) {
          val pokemon1 = new Pokemon(name1, hp1, str1)
          val pokemon2 = new Pokemon(name2, hp2, str2)
          pokemon1.attack(pokemon2)
          pokemon2._currentHp shouldBe 0
          pokemon2.isKo shouldBe true
        }
    }
  }
}
