package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-08.
 */
class NullETCTest {
    @Test
    @Throws(Exception::class)
    fun safeCheckTest() {
        val a: Any? = "name"

//        as 뒤에 ?를 붙여서 안전한 instanceof 체크가 가능함
        val b: Int? = a as? Int ?: 0

        println(b)
    }

    @Test
    @Throws(Exception::class)
    fun ListWithNullTest() {
        val listWithNulls: List<String?> = listOf("A", null, "B")

//        보통 리스트에서 null을 제외하는 방법
        for (item in listWithNulls) {
            if (item != null) {
                println("Text: $item")
            }
        }

//        스트림을 사용하는 방법
        listWithNulls.filter { it != null }
                .forEach { println("Text: $it") }

//        제공되는 함수를 이용하는 방법
        val itemList: List<String> = listWithNulls.filterNotNull()
        itemList.forEach { println("Text: $it") }
    }

    data class Sample(val name: String, val age: Int, val id:String)

    @Test
    @Throws(Exception::class)
    fun letNullCheckTest() {
        val sample: Sample? = Sample("User name", 20, "User Id")

//        원래는 이렇게 해야 하지만,
//        val text1 = sample?.name ?: ""
//        val text2 = sample?.age ?: 0
//        val text3 = sample?.id ?: ""

//        let을 사용하면 간단하게 처리할 수 있다
        sample?.let {
            val text1 = it.name
            val text2 = it.age
            val text3 = it.id
//        } ?: println("sample이 null입니다")
        } ?: let {
            val text1 = "invisible"
            val text2 = "invisible"
            val text3 = "invisible"
        }

//        리스트 null 처리도 let으로 가능하다
        val listWithNulls: List<String?> = listOf("A", null, "B")
        for (item in listWithNulls) {
            item?.let { println(it) } // null을 무시하게 된다!
        }
//        스트림으로 하면
//        listWithNulls.forEach { it?.let { println(it) }
    }

    @Test
    @Throws(Exception::class)
    fun externalLibraryNullCheckTest() {
//        1개 이상의 null 체크를 하는 방법
        val a: String? = "AAA"
        val b: String? = "BBB"

//        보통 하는 방법
        if (a != null && b != null) {
            println("$a $b")
        }

//        safeLet 라이브러리를 사용하는 방법
        safeLet(a, b) { a, b ->
            println("$a $b")
        }

//        unwrap 라이브러리를 사용하는 방법
        val _a = foo("Hello")
        val _b = foo(null)

        unwrap(_a, _b) {a, b ->
            println("$a, $b") // _b가 null 이므로 호출 안됨
        } otherwise {
            println("null이 하나 있네요!")
        }

    }

    private fun <T1: Any, T2: Any, R: Any>safeLet(p1: T1?, p2: T2?, block: (T1, T2)->R?): R?
        = if (p1 != null && p2 != null) block(p1, p2) else null

    private fun foo(name: String?): String? = name

    class Unwrap(private var vaild: Boolean) {
        infix fun <R> otherwise(f: () -> R) {
            if (!vaild) f()
        }
    }

    private inline fun <T1, T2, R> unwrap(
            t1: T1?, t2: T2?,
            block: (T1, T2) -> R): Unwrap {
        val vaild = null !in arrayOf(t1, t2)
        if (vaild) block(t1!!, t2!!)
        return Unwrap(vaild=vaild)
    }
}