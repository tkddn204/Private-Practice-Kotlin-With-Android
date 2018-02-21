package me.ssangwoo.kotlinlecture.section4

/**
 * Created by 쌍우 on 2018-02-21.
 */
class DataClassTest {

}

// data는 toString과 hashcode, equal 등의 Object 메소드들을 자동으로 구성해준다.
// 생성자 파라미터는 순서대로 번호가 붙기 때문에,
// 가급적 새로운 변수는 뒤에다 만들어주는게 좋다.
data class DataUserInfo(var temp: String?, var name: String?, var age: Int?)


/* 싱글톤 */

// object는 싱글톤으로 쓸 수 있다.
// 생성자를 가질 수 없음(필드를 가질수 없음)
object Eager

// 생성자를 가지고 싶으면 Companion Object를 이용하면 된다.
// 구글에서 제안한 방법
class Singleton private constructor(val name: String) {
    companion object {
        @Volatile private var INSTANCE: Singleton? = null

        fun getInstance(name: String): Singleton =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Singleton(name).also { INSTANCE = it }
                }
    }
}

// 레이지 로딩으로도 가능하다
// 역시 이것도 값을 넘겨주지는 못한다..
class Lazy {
    companion object {
        private val INSTANCE: Lazy by lazy {
            Lazy()
        }
        fun getInstance() = INSTANCE
    }
}

// 내부 클래스(inner)
class Outer {
    private val bar = 1

    // inner를 붙여야 우리가 아는 내부 클래스로써 사용이 가능하다
    inner class Nested {
        fun foo() = 2
    }
}


// 익명 클래스
// 따로 액티비티를 만들음(section4.anonymous)