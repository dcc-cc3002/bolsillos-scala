package cl.uchile.dcc.poke

class GrassPokemon(name: String, maxHp: Int, strength: Int)
  extends AbstractPokemon(name, maxHp, strength) {
  override def attack(pokemon: Pokemon): Unit = {
    pokemon match {
      case _: FirePokemon =>
        pokemon.currentHp -= strength / 10 * 1.5
      case _: GrassPokemon =>
        pokemon.currentHp -= strength / 10 * 0.5
      case _ =>
        pokemon.currentHp -= strength / 10
    }
  }
}
