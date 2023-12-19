package kr.amaranth.kotlinexample

fun main(args: Array<String>) {

    val student = Student()
    student.study()

    val soccerPlayer = SoccerPlayer()
    soccerPlayer.study()

}

/*
인터페이스 : 생성자가 없다, 인스턴스화가 불가능하다.
인터페이스에도 구현이 있는 함수를 만들 수 있다.
인터페이스에 구현메서드는 그 인터페이스를 구현하는 클래스에서 해당 함수를 구현하지 않아도 된다.
 */
interface Person {
    fun eat() {
        println("먹는다")
    }

    fun sleep() {
        println("잔다")
    }

    abstract fun study()
}

class Student() : Person {
    override fun sleep() {
//        super.sleep()
        println("사람이 잔다")
    }

    override fun study() {
        println("공부를 한다")
    }
}

class SoccerPlayer : Person {
    override fun study() {
        println("운동을 한다")
    }
}