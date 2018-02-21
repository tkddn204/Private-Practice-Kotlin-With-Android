package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-21.
 */
class GenericTest {

    private fun <T> createArrayList(): List<T> {
        return ArrayList()
    }

    // 와일드카드
    // 자바에서는 extends와 super를 쓴다
    // ? super T : write만 가능한 '슈퍼' 와일드카드
    // ? extends T : read만 가능한 '서브' 와일드카드
    // 코틀린에서는 in과 out을 쓴다
    // T : 읽기/쓰기 가능
    // in T : ? super T와 같이 쓰기만 가능
    // out T : ? extends T와 같이 읽기만 가능
    private fun printAll(items: ArrayList<out Output<String>>) {
        items.indices
                .filter { items[it].isArgument("") }
                .forEach { println("items : ${items[it]}") }
    }

    // 스타 프로젝션
    // 별 넣으면 Any로 들어가서 모든 타입으로 들어가는 것이 가능하다
    private fun printArrayList(list: List<*>) {
        list.forEach {
            println("it $it")
        }
    }

    @Test
    internal fun test() {
//        createArrayList<String>()
//        createArrayList() 처럼 타입 정의를 안해주면 오류가 난다
//        안하고 싶으면 Any를 쓰자
//        createArrayList<Any>()
        printArrayList(mutableListOf("AA", "BB", "CC"))
        printArrayList(mutableListOf(1, 2, 3, 4, 5))
    }


}

internal interface Output<in T> {
    fun isArgument(name: T): Boolean
}