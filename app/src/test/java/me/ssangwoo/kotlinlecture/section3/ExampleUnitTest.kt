package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun additionIsCorrect() {
        assertEquals(4, 2 + 2)

        // ===
        val a = 10_000
        println(a === a)
        val boxedA: Int? = a
        val anotherA: Int? = a
        println(boxedA === anotherA)

        // ==와 equals()는 같음
        println(a == a)
        println(boxedA == anotherA)
        println(boxedA?.equals(anotherA))
    }

    @Test
    @Throws(Exception::class)
    fun StringTemplete() {
        val list = mutableListOf("a", 0, 1, "B")

        println("list $list")
        println("list ${list.size}")
        println("list ${list.size > 4}")

        val name = "abc"
        for (ch in name) {
            println("charAp($ch)")
        }

        val price = 10_000
        println("price $$price")
    }

    @Test
    @Throws(Exception::class)
    fun ValueTest() {
        val a = 1
        var b = 2

        val name1 = "name"
//        name1 = null 안됨!
        var name2 = "name"
    }

    @Test
    @Throws(Exception::class)
    fun NullTest() {
        // null 초기화를 하기 위해서는 자료형 뒤에 물음표를 붙여야 한다
        var nameToNull: String? = null
        nameToNull = "null??"

        print(nameToNull?.length)

        // null로 초기화한 변수는 Nothing으로써 할당이 불가능함
        // Nothing은 자바의 Void형과 똑같음
        var nul = null
        var nul1:Nothing? = null
//        nul = "asdf" 안됨
//        null로 초기화를 하고 싶으면, Any 객체를 쓰면 가능함
//        Any 객체는 자바에서 Object와 동등한 객체!!!
        var an:Any? = null
        an = "hello"
        print(an)
    }

    @Test
    @Throws(Exception::class)
    fun ListTest() {
        var sl : SampleList<Int>
    }

    class SampleList<T> {
        var list: List<T> = mutableListOf()
//            private set(value) {
            set(value) {
                if (value.isNotEmpty()) {
                    field = value
                }
            }
            get() = field

        val isEmpty: Boolean
            get() = this.list.isEmpty()

    }

//    lazy 키워드로 초기화
//    private val name by lazy {
//        "name"
//    }
//    lateinit 키워드
//    초기값 적용 필요 없음
//    nullable 허용 불가능
//    늦은 초기화니까 초기화 전에 사용하면 오류가 발생함
//    getter/setter 사용 불가능
    private lateinit var name: String

    @Test
    @Throws(Exception::class)
    fun lazy() {
        name = "asdf"
        assertEquals("asdf", name)
    }

}
