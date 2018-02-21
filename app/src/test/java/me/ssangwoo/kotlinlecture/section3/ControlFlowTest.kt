package me.ssangwoo.kotlinlecture.section3

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-07.
 */
class ControlFlowTest {
    @Test
    @Throws(Exception::class)
    fun ConditionTest() {
        val vaildNumbers = 9..10
        val a:Any = 30
        when (a) {
//            범위를 정할 경우 if 문으로 나눠진다
            in 1..10 -> println("1~10")
            is String -> println("스트링")
            else -> println("else")
//            그냥 몇개를 선정하면 switch 문으로 나눠진다
//            1, 20 -> println("1 or 20")
//            else -> println("else")
        }
        printSample(SampleOne("네임"))
        printSample(SampleTwo(20))
    }

    // 반환값 있는 when 함수
    fun isString(a: Any) = when(a) {
        is String -> true
        else -> false
    }

    @Test
    @Throws(Exception::class)
    fun RepeatTest() {
        var list = mutableListOf(1, 2, 3, 4)

        // 보통 쓰는 for 방법
        for (i in list) {
            println("i $i")
        }

        // 인덱스 for
        for (i in list.indices) {
            println("indices - i $i")
        }

        // 인덱스, 값 for
        // 키- 밸류 형태로 불러옴
        for ((index, value) in list.withIndex()) {
            println("index: $index, value: $value")
//            if (index == 1) break
        }

        // 스텝으로 뛰어넘을 수 있음
        for (value in 1..10 step 2) {
            println("step - $value")
        }

        // map for
        val map = mutableMapOf(1 to "ABC", 2 to "BBB", 3 to "CCC")
        for ((index, value) in map) {
            println("map :: $index, $value")
        }

    }
}

fun printSample(sample: Sample) {
    when (sample) {
        is SampleOne -> println("sample name: ${sample.name}")
        is SampleTwo -> println("sample age: ${sample.age}")
    }
}

sealed class Sample
data class SampleOne(val name: String): Sample()
data class SampleTwo(val age: Int): Sample()