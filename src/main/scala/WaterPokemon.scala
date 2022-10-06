package cl.uchile.dcc.poke

class WaterPokemon(name: String, maxHp: Int, strength: Int)
  extends AbstractPokemon(name, maxHp, strength) {
  override def attack(pokemon: Pokemon): Unit = {
    pokemon.receiveWaterAttack(this)
  }

  override def receiveWaterAttack(waterPokemon: WaterPokemon): Unit = {
    normalDamageFrom(waterPokemon)
  }

  override def receiveFireAttack(firePokemon: FirePokemon): Unit = {
    resistantDamageFrom(firePokemon)
  }

  override def receiveGrassAttack(grassPokemon: GrassPokemon): Unit = {
    weaknessDamageFrom(grassPokemon)
  }
}
