package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class NullTest {

//    파라미터는 기본으로 NotNull 이고,
//    물음표를 붙이면 Nullable이 된다
    fun setInfo(a: String, b: String?) {
        println("a $a, b $b")
    }

    fun getSize(a: String?) = a?.length

    @Test
    @Throws(Exception::class)
    fun test() {
//        setInfo("asdf", null)
        val temp: String? = null

//        세이프 콜 방식
//        temp?.length
        print(getSize(temp))

        val aaa: AAA? = AAA(BBB(null))
        val name = aaa?.bbb?.ccc?.name
        println("name $name")
    }

    data class AAA(val bbb: BBB?)
    data class BBB(val ccc: CCC?)
    data class CCC(val name: String?)
}