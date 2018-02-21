package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class KotlinMethodTest {
    @Test
    @Throws(Exception::class)
    fun test() {
        print("합계 : ${getSum(0, 1)}")
        list.add("one")
        list.add("two")
        list.forEach { num -> println(num) }
        getOne()
        println(1.thisSum(123))
    }

    val list: MutableList<String> = mutableListOf()

    // void 메소드
    private fun getOne(): Unit {
        println(list[0])
    }

    // 인라인 메소드
    private fun getSum(a: Int, b: Int): Int? = a + b

    // 앞에 사용될 지정자를 적는게 가능하다
    fun Int.thisSum(x: Int): Int
        = this + x

}

// 클래스 밖에서 정의하는 경우, infix로 만들면
// 파일명으로 접근이 가능하다
// 예: KotlinClassTest.getInfixSum(1, 2)
infix fun Int.getInfixSum(a: Int) = this + a
