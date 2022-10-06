package cl.uchile.dcc.poke

import java.util.Objects

abstract class AbstractPokemon(
    val name: String,
    val maxHp: Int,
    val strength: Int
) extends Pokemon {
  var _currentHp: Int = maxHp

  def currentHp: Int = _currentHp

  def currentHp_=(newHp: Int): Unit = {
    _currentHp = math.max(0, math.min(newHp, maxHp))
  }

  def attack(pokemon: Pokemon): Unit = {
    pokemon.currentHp -= strength / 10
  }

  def isKo: Boolean = {
    _currentHp == 0
  }

  override def equals(obj: Any): Boolean = obj match {
    case that: Pokemon =>
      classOf[Pokemon] == obj.getClass &&
        this.name == that.name &&
        this.maxHp == that.maxHp &&
        this.strength == that.strength
    case _ => false
  }

  override def hashCode(): Int =
    Objects.hash(classOf[Pokemon], name, maxHp, strength)
}
