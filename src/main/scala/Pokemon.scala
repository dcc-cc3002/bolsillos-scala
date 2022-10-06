package cl.uchile.dcc.poke

trait Pokemon {
  val name: String
  val maxHp: Int
  val strength: Int
  var currentHp: Int

  def attack(other: Pokemon): Unit

  def isKo: Boolean
}
