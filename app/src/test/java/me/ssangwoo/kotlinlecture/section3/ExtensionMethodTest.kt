package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class ExtensionMethodTest {
    @Test
    @Throws(Exception::class)
    fun test() {
        printfoo(D())
    }

    open class C

    class D: C()

    fun C.foo() = "C"

    fun D.foo() = "D"

    private fun printfoo(c: C) {
        println(c.foo())
    }

    // 같은 이름을 가진 함수가 있을 때,
    // 확장 함수보다 내부 함수가 우선 호출된다.
    class E {
        fun foo() {
            println("member")
        }
    }

    fun E.foo() = "extension"


    // 확장 속성
    // mutableListOf(1, 0, 3, 50, 30).lastIndex로 사용 가능
    val <T> List<T>.LastIndex: Int
        get() = size - 1
}