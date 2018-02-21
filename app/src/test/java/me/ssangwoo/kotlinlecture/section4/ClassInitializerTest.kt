package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-14.
 */
class ClassInitializerTest {
    @Test
    internal fun test() {
//        Sample("", 0)
    }

    class Sample(val name: String, val age: Int, val birth: String) {
        init {
            println("init")
        }

//        constructor(name: String) {
//            println("constructor")
//        }
//
//        constructor(name: String, age: Int): this(name) {
//            println("two constructor")
//        }
    }

    class UserInfoInit @JvmOverloads constructor(
            name: String = "Name",
            age: Int = 0,
            birthday: String = "2000-01-01") {
        // 전역 변수
        val name: String = name.takeIf { it.isNotEmpty() } ?: ""
        val age: Int
        val birthday: String

        // 유효성 검증
        init {
//            this.name = name.takeIf { it.isNotEmpty() } ?: ""
            this.age = age.takeIf { it > 0 } ?: 0
            this.birthday = birthday.takeIf { it.isNotEmpty() } ?: ""
        }
    }
}

class UserInfo(val name: String, val age: Int)

class UserInfo2 {
    var name: String = ""
    var age: Int = 0
    constructor(name: String, age: Int) {
//        val은 다시 수정할 수 없음
//        세컨더리 생성자를 사용하기보다는 프라이머리가 훨씬 더 좋다
        this.name = name
        this.age = age
    }
}

class UserInfoPrimary constructor(
        val name: String = "Name",
        val age: Int = 0
)

