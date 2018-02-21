package me.ssangwoo.kotlinlecture.section4.samclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tx: TextView = TextView(this)
//        tx.setOnClickListener()

        // Single Abstract Method
        // interface/abstract인 경우에만 정의 가능
        // setter도 정의해야 한다
        // 그리고 __반드시__ **자바 파일**로 정의되어 있어야 SAM이 작동된다
        tx.setOnClickListener {
            // 이것이 바로 SAM
        }

        onClickSAM = {
            a, b ->
            println("OnClickSAM $a, $b")
        }
    }

    // 코틀린 안에서 만들 수 있는 SAM
    // 처음 생각할 땐 이 방식을 떠올릴 수 있다
//    private lateinit var samInterface: SAMInterface
//
//    private fun setSAM(onClick: (Int) -> Unit, onClickSAM: () -> Unit) {
//        samInterface = object : SAMInterface {
//            override fun onClick(position: Int) {
//                onClick(position)
//            }
//
//            override fun onClickSAM() {
//                onClickSAM()
//            }
//        }
//    }

    // 수정된 방식
    // 파라미터 몇개가 있다고 주석을 달아줘야 하는 단점이이 있으나
    // 훨씬 쉽고 간결한 방법
    private lateinit var onClickSAM: (Int, Int) -> Unit

    interface SAMInterface {
        fun onClick(position: Int)
        fun onClickSAM()
    }
}
