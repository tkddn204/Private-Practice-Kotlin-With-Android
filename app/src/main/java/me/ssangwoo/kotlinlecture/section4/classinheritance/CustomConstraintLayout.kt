package me.ssangwoo.kotlinlecture.section4.classinheritance

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Created by 쌍우 on 2018-02-14.
 */
open class CustomConstraintLayout @JvmOverloads constructor(
//        코틀린에서 만든 코드를 자바에서 쓰려면 JvmOverloads 어노테이션을 붙이면 된다
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)