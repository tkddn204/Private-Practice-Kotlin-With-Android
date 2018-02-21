package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-08.
 */
class NullExceptionTest {

//    Elvis Operator ( ?: 으로 null 확인)
//    if (a != null) a else 0 과 같음
//    fun getSize(a: String?):Int = a?.length ?: 0

//    트라이캐치 한줄
    fun getSize(a: String?):Int = try {a!!.length} catch (e:NullPointerException) {0}

    @Test
    @Throws(Exception::class)
    fun test() {
        val temp: String? = null

//        println("size ${getSize(temp)}")

//        NPE(널포인터 익셉션)을 발생시키려면 !!을 써준다.
//        트라이-캐치일 때 써주면 좋다
        println("size ${getSize(temp!!)}")

//        또는 Throw를 써줄 수 있다.
//        val size = temp.length ?: throw NullPointerException("temp는 Null입니다")
    }
}