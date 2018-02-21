package me.ssangwoo.kotlinlecture.section4.classinheritance;

import android.content.Context;
import android.util.AttributeSet;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by 쌍우 on 2018-02-14.
 */

public class Custom extends CustomConstraintLayout {
    public Custom(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Custom(@NotNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Custom(@NotNull Context context) {
        super(context);
    }
}
