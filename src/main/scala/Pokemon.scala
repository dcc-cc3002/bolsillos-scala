package cl.uchile.dcc.poke

import java.util.Objects

class Pokemon(val name: String, val maxHp: Int, val strength: Int) {
  var currentHp: Int = maxHp

  def attack(pokemon: Pokemon): Unit = {
    pokemon.currentHp -= strength / 10
  }

  def isKo: Boolean = {
    currentHp == 0
  }

  override def equals(obj: Any): Boolean = obj match {
    case that: Pokemon => classOf[Pokemon] == obj.getClass &&
      this.name == that.name &&
      this.maxHp == that.maxHp &&
      this.strength == that.strength
    case _ => false
  }

  override def hashCode(): Int = Objects.hash(classOf[Pokemon], name, maxHp, strength)
}
