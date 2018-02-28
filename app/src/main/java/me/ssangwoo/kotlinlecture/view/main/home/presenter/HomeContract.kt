package me.ssangwoo.kotlinlecture.view.main.home.presenter

/**
 * Created by 쌍우 on 2018-02-26.
 */
interface HomeContract {
    interface View {
        fun showImage(imageName: String)
        fun hideProgress()
        fun showProgress()

    }

    interface Presenter {
        fun loadImage()
    }
}