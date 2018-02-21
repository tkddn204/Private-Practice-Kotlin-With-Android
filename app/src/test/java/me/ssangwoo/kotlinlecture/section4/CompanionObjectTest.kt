package me.ssangwoo.kotlinlecture.section4

import org.junit.Test

/**
 * Created by 쌍우 on 2018-02-14.
 */
class CompanionObjectTest {
    @Test
    internal fun test() {
        Sample.type
        // 자바는 Sample.Companion.getType()
        Sample2.NAME
        // 어노테이션을 붙였으면 자바도 그냥 불러오는게 가능
    }
}

class Sample {

    val name: String = "Name"

//    보통 필드의 변수는 스태틱으로 선언되지 않는다.
//    컴패니언 변수는 기본적으로 프리베이트 **스태틱**으로 선언된다
    companion object {
        val type: Int = 0

        fun isTypeZero(): Boolean {
            return type == 0
        }
    }
}

interface Sample2 {
    companion object {
        const val type: Int = 0
        const val NAME: String = ""

//        원래 자바에서는 Sample2.Companion.isTypeZero() 라고 해야되지만
//        어노테이션을 붙여주면 Sample2.isTypeZero() 로 호출이 가능하게 된다
//        @JvmStatic
        fun isTypeZero(): Boolean {
            return type == 0
        }
    }
}

class Sample3 {
    // 팩토리로도 응용이 가능
    companion object Factory {
        fun create(): Sample3 =  Sample3()
    }
}
