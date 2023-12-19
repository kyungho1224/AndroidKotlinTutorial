package kr.amaranth.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InterfaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)

//        val student : Student = Student()
//        student.eat()
//        student.sleep()

    }

    /*
    인터페이스 : 생성자가 없다, 인스턴스화가 불가능하다
     */
//    interface Person {
//        fun eat()
//        fun sleep()
//    }
//
//    class Student() : Person {
//
//        override fun eat() {
//            println("먹는다1")
//        }
//
//        override fun sleep() {
//            println("잔다1")
//        }
//
//    }
//
//    class SoccerPlayer : Person {
//
//        override fun eat() {
//            println("먹는다2")
//        }
//
//        override fun sleep() {
//            println("잔다2")
//        }
//
//    }

}