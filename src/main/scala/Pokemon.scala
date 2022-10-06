package cl.uchile.dcc.poke

trait Pokemon {
  val name: String
  val maxHp: Int
  val strength: Int
  var currentHp: Int

  def attack(other: Pokemon): Unit

  def isKo: Boolean

  def receiveWaterAttack(waterPokemon: WaterPokemon): Unit

  def receiveFireAttack(firePokemon: FirePokemon): Unit

  def receiveGrassAttack(grassPokemon: GrassPokemon): Unit
}
