package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-21.
 */
class KotlinSTLTest {
    @Test
    internal fun test() {
        show("")
        show(null)
    }

    fun show(name: String?) {
        // let은 데이터 null 체크를 할 때 주로 사용함
        name?.let {
            println("name : $it, len : ${it.length}")
        }.let {
                    println("null")
                }
    }

    // apply는 생성과 동시에 값을 초기화할 때 유용함
    // 액티비티를 만들어서 텍스트뷰로 예를 들어보자
    // with도 설명해놈

    // also는 첫번째 블록과 두번째 블록을 분리시켜줌
    data class Block(var name: String = "", var age:Int = 10)

    fun Block.copyName(age: Int) = Block().also {
        it.name = this.name
        it.age = age
    }

    @Test
    fun alsoTest() {
        val block = Block("ABC")
        val temp = block.copyName(20)
        println("block $block temp $temp")
    }

    // takeif는 받아온 값을 체크하고 틀리면 null
    fun takeCheck() {
        val block = Block("ABCD")
        println("out ${block.takeIf { it.age > 10 }}")
    }

    // takeUnless는 takeif의 반대임
    fun takeNotCheck() {
        val block = Block("ABCDE")
        println("out ${block.takeUnless { it.age > 10 }}")
    }

    @Test
    fun takeCheckTest() {
        takeCheck()
        takeNotCheck()
    }
}