package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class JumpExpressionTest {
    @Test
    @Throws(Exception::class)
    fun test() {
        // 람다는 함수에 리턴값이 있을 경우 '마지막 줄'이 리턴값이다!

//        루프 레이블
//        레이블을 연결시켜서 레이블이 찍힌 곳의 반복문을 break하게 된다!
        loop@ for (i in 1..10) {
            for (j in 1..10) {
                // break에 걸리면 밖의 for이 종료된다!
                if (j > 5) break@loop
                print(j)
            }
            println()
        }

        val intList = mutableListOf(1, 2, 0, 4, 5)
        intList.forEach /*lit@*/ {
            // 그냥 리턴을 하면 test()를 리턴하게 되는데,
            // 레이블을 해주면 레이블이 표시된 곳을 리턴한다!
//            if (it == 0) return@lit
            // 함수명으로도 가능하다!
            if (it == 0) return@forEach
            print(it)
        }
    }

    // this expression
    class Sample {
        inner class SampleB {
            fun Int.foo() {
                val a = this@Sample
                val a1 = this@SampleB
                test()
                this@Sample.test()
            }
            fun test() {
                println("sampleB test")
            }
        }

        fun test() {
            println("sample test")
        }
    }
}