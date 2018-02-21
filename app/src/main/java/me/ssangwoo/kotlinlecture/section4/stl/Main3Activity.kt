package me.ssangwoo.kotlinlecture.section4.stl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.LinearLayout
import android.widget.TextView
import me.ssangwoo.kotlinlecture.R

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* apply 예제 */

        // 원래는 이렇게 메소드를 나열하면서 선언해줬다
        val textView = TextView(this)
        textView.text = "button"
        textView.setTextColor(ContextCompat.getColor(
                this, R.color.abc_background_cache_hint_selector_material_dark))
        textView.setOnClickListener {}

        // apply를 사용하면 다음과 같은 구현이 가능하다
        // 생성과 동시에 구현을 할 때 유용하게 쓰일 수 있다
        val textView2 = TextView(this).apply {
            text = "button"
            setTextColor(ContextCompat.getColor(
                    this.context, R.color.abc_background_cache_hint_selector_material_dark))
            setOnClickListener {}
        }

        // run은 이미 생성한 객체에 대해 다시 접근하여
        // 여러 동작을 구현할 때 유용함
        textView.run {
            text = "button2"
            textSize = 20f
        }
    }
    // with은 view에 접근할 때 주로 사용함
    fun onBindView() {
        with(setContentView(LinearLayout(this))) {
            // ...
        }
    }
}
