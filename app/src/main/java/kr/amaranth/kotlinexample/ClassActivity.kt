package kr.amaranth.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        Car("strong", "big")

        val bigCar: Car = Car("strong", "big")
        val superCar: SuperCar = SuperCar("nice", "very big", "white")

        val verySuperCar1: VerySuperCar = VerySuperCar("very nice", "very big")
        val verySuperCar2: VerySuperCar = VerySuperCar("very nice", "very big", "red")

        val kingSuperCar1: KingSuperCar = KingSuperCar("very good", "excellent")
        val kingSuperCar2: KingSuperCar = KingSuperCar("very good", "excellent", "blue")

        val runnableCar: RunnableCar = RunnableCar("simple", "good")
        runnableCar.ride()
        runnableCar.drive()
        runnableCar.navi("Osaka")

        val runningCar: RunningCar = RunningCar("good", "nice")
        println(runningCar.engine)
        println(runningCar.body)

    }

    /* 1. 자바와 동일 */
    class SuperCar {
        private var engine: String
        private var body: String
        private var door: String

        constructor(engine: String, body: String, door: String) {
            this.engine = engine
            this.body = body
            this.door = door
        }
    }

    /* 2. 1번의 축약형 */
    class Car(private var engine: String, private var body: String) {

    }

    /* required parameter and optional parameter */
    class VerySuperCar(private var engine: String, private var body: String) {
        private var door: String = ""

        constructor(engine: String, body: String, door: String) : this(engine, body) {
            this.door = door
        }
    }

    class KingSuperCar {
        private var engine: String = ""
        private var body: String = ""
        private var door: String = ""

        constructor(engine: String, body: String) {
            this.engine = engine
            this.body = body
        }

        constructor(engine: String, body: String, door: String) {
            this.engine = engine
            this.body = body
            this.door = door
        }
    }

    class RunnableCar(engine: String, body: String) {
        fun ride() {
            println("탑승 완료")
        }

        fun drive() {
            println("출발")
        }

        fun navi(destination: String) {
            println("$destination(으)로 목적지 설정")
        }
    }

    class RunningCar {
        var engine: String = ""
        var body: String = ""

        constructor(engine: String, body: String) {
            this.engine = engine
            this.body = body
        }

        init {
            println("RunningCar make")
        }

        fun ride() {
            println("탑승 완료")
        }

        fun drive() {
            println("출발")
        }

        fun navi(destination: String) {
            println("$destination(으)로 목적지 설정")
        }
    }

    open class ParentCar() {
        open fun drive() {
            println("달린다")
        }

        open fun speedUp() : String {
            return "속도를 올린다"
        }

        open fun stop() {

        }
    }

    class Bus() : ParentCar() {
        override fun drive() {
            println("빨리 달린다")
        }

        override fun speedUp(): String {
            val speed = super.speedUp()
            return "100만큼 $speed"
        }
    }

    ///////////////////////////////////////////////////////////////

    open class Character(var hp: Int, val power: Int) {

    }

}