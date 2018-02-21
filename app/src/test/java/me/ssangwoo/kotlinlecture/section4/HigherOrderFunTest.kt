package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-21.
 */
class HigherOrderFunTest {

    // 람다식을 통해 축약형태로 함수를 리턴 가능하게 만듦
    // 변수로 함수를 가질 수 있음
    fun myPrint(body: () -> String) {
        println("내 프린트")
        println(body())
    }

    // 실제로는 이런 형태임
    fun OriginalPrint() {
        println(body())
    }
    fun body() = "함수로 프린트!!!!!"

    // 파라미터가 있는 형태
    fun paramPrint(body: (Int) -> String) {
        println(body(1))
    }
    fun twoParamPrint(body: (String, String) -> String) {
        println(body("a", "b"))
    }

    // 함수 파라미터를 2개 사용할 때
    fun twoFunPrint(header: (String) -> String, body: () -> String) {
        println(header("헤더"))
        println(body())
    }

    // 변수에다가 정의도 가능하다.
    var higherOrderFunction: () -> Unit = {
        println("Print!!!")
    }

    // lateinit을 사용하면 사용할 때 초기화를 해줘야 한다
    lateinit var lateHOFunction: (String) -> Unit

    // 계산기를 만들어보는 예
    fun higherOrder(body: (Int, Int) -> Int) = body(20, 10)

    @Test
    internal fun test() {
//        myPrint { "프린트!!" }

//        OriginalPrint()

//        paramPrint { "$it, 파라미터 프린트!!!" }
//        twoParamPrint { s1, s2 -> "$s1, $s2, 파라미터 2개!!!" }

//        twoFunPrint({
//            "$it -> 헤더 내용!!!"
//        }) {
//            "바디 내용!!!!!!"
//        } // 함수가 2개 이상이면 마지막 함수에만 괄호 밖에서 사용이 가능하다

//        // 다른 메소드 직접 호출
//        twoParamPrint { one, two ->
//            message(one, two)
//        }
//        // 위 내용을 이렇게 줄일 수 있음
//        twoParamPrint(::message)

//        // 변수인데도 함수처럼 사용이 가능하게 된다
//        higherOrderFunction()
//
//        // lateinit 키워드를 사용하면 초기화를 사용 시에 할 수 있음
//        lateHOFunction = {
//            println(it)
//        }

        // 계산기 예제
        println(higherOrder(::sum))
        println(higherOrder(::minus))
        println(higherOrder(::multifly))
        println(higherOrder(::division))

    }

}

fun message(a: String, b: String) = "$a, $b"

// 계산기를 위한 함수
fun sum(a: Int, b: Int) = a + b
fun minus(a: Int, b: Int) = a - b
fun multifly(a: Int, b: Int) = a * b
fun division(a: Int, b: Int) = a / b