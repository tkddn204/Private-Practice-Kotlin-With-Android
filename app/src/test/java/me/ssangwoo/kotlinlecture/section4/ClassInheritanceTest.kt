package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-08.
 */
class ClassInheritanceTest {
    @Test
    @Throws(Exception::class)
    fun test() {
        InterfaceSample().newDefaultMethod()
    }

    abstract class Base(val a: Int) {
//        그냥 함수는 final이기 때문에, 재정의가 불가능하다
//        재정의 할 수 있는 함수로 만들어주기 위해서는 앞에 open을 붙여주면 된다
        open fun printBase() {
            println("value a : $a")
        }

        abstract fun equals(): Boolean
    }

    class Sample(a: Int, private val b: Int) : Base(a) {

        override fun equals(): Boolean = a == b
    }

    interface BaseInterface {
        val a: Int // java와는 다르게 interface의 변수는 초깃값을 가질 수 없음
        fun existingMethod()
        fun newDefaultMethod() {
            println("value $a")
        }
    }

    class InterfaceSample : BaseInterface {
        override val a: Int
            get() = 0 // 변수도 get()으로 오버라이드를 해줘야 된다

        override fun existingMethod() { }

        override fun newDefaultMethod() {
            super.newDefaultMethod()
            print("Sample")
        }
    }

    @Test
    @Throws(Exception::class)
    fun TwoInheritanceTest() {
        C().f()
        C().c()
    }

    open class A {
        open fun f() { print("A") }
        fun a() { print("a") }
        open fun c() { print("c") }
    }

    interface B {
        // 인터페이스 함수는 기본으로 open
        fun f() { print("B") }
        fun b() { print("b") }
        fun c() { print("c") }
    }

    class C(): A(), B {
        override fun f() {
            super<A>.f()
            super<B>.f()
        }

        override fun c() {

        }
    }

}