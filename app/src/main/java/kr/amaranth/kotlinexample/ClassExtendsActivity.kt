package kr.amaranth.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ClassExtendsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_extends)

        val monster = SuperMonster(100, 10)
        val knight = SuperKnight(130, 8)
        monster.attack(knight)
        monster.bite(knight)

    }

    open class Monster(var hp: Int, val power: Int) {
        fun attack() {

        }

        fun defense() {

        }
    }

    open class Knight(var hp: Int, val power: Int) {
        fun attack() {

        }

        fun defense() {

        }
    }

    open class Character(var hp: Int, val power: Int) {
        fun attack(character: Character, power: Int = this.power) {
            character.defense(power)
        }

        open fun defense(damage: Int) {
            hp -= damage
            if (hp > 0) println("${javaClass.simpleName}의 남은 체력 $hp")
            else println("사망 했습니다.")
        }
    }

    // 자식 클래스가 인스턴스화 되기 위해서는 부모 클래스가 선행되어 인스턴스화 되어야 한다
    class SuperMonster(hp: Int, power: Int) : Character(hp, power) {

        fun bite(character: Character) {
            super.attack(character, power + 2)
        }

    }

    class SuperKnight(hp: Int, power: Int) : Character(hp, power) {
        val defensePower = 2
        override fun defense(damage: Int) {
            super.defense(damage - defensePower)
        }
    }

}