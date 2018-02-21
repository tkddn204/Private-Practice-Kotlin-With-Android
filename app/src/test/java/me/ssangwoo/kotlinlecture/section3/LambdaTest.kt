package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class LambdaTest {
    @Test
    @Throws(Exception::class)
    fun test() {
        Button().setOnListener {
//            람다로 표현 가능하며,
            view -> println(view.name)
//            싱글 파라미터인 경우에는 it 키워드를 쓸 수도 있다
//            println(it.name)
        }

//        클로져
        var count: Int = 0
        Button().setOnListener {
            count++
        }

//        스트림
        var list = mutableListOf(1, 2, 3, 4, 5)
        list.filter { item -> item > 3 }
                .map { println("아이템 $it") }

        var map = mutableMapOf("a" to "AA", "b" to "BB", "c" to "CC")
        map.forEach { _, value ->
            println(value)
        }
    }
}

open class View {
    val name = "view"

    interface Listener {
        fun listen(view: View)
    }
}

class Button: View() {
    var listener: Listener? = null

    fun setOnListener(listener: (View) -> Unit) {
        this.listener = object: Listener {
            override fun listen(view: View) {
                listener(view)
            }
        }
    }
}