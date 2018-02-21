package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class KotlinClassTest {
    @Test
    @Throws(Exception::class)
    fun test() {
//        val sample = Sample("name")
//        sleep(1)
//        val sample2 = Sample(name="name", age=20)
        val customer = Customer(10, "이---름")
        customer.printInformation()
    }

//     primary constructor - constructor 생략 가능
//    class sample constructor(val name: String) {
    class Sample(val name: String, val age: Int = 10) {

        private val customerName = name.toUpperCase()
//        secondary constructor
        constructor(name: String): this(name, 0) {
            println("second: $name, $age - $customerName")
        }
        init {
            println("init: $name, $age")
        }
    }

    abstract class AbstractAge(val age: Int)

    interface InterfaceName {
        fun printInformation(): Boolean
    }

    // 기본적으로 클래스는 final로 선언이 되어, 그냥 상속하지 못함
    // 상속을 하고싶으면, 앞에 open 키워드를 붙여줘야 함
    class Customer(age: Int, val name: String) : AbstractAge(age), InterfaceName {
        override fun printInformation(): Boolean {
            println("이름 : $name, 나이 : $age")
            return true
        }
    }

    open class User(age: Int) : AbstractAge(age)

}