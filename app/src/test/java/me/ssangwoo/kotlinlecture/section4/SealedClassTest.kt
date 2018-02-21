package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-21.
 */
class SealedClassTest {
    @Test
    private fun test() {
        println(eval(Sum(Const(1.0), Const(1.5))))
    }

    fun eval(expr: Expr): Double = when(expr) {
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NotANumber -> Double.NaN
//        사실 else는 필요하지 않다
        else -> {0.0}
    }
}

// 생성자가 private으로 선언된다
// sealed 클래스는 반드시 상속에 관련되는 것은 하나의 파일에 모든 클래스가 있어야한다
// 모든 메소드는 상속을 하도록 abstract 키워드가 앞에 붙는다
sealed class Expr(val name: String)
data class Const(val number: Double) : Expr("")
data class Sum(val e1: Expr, val e2: Expr) : Expr("")
object NotANumber : Expr("")
