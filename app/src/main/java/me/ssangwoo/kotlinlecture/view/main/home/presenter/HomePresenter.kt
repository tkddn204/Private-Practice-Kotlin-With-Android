package me.ssangwoo.kotlinlecture.view.main.home.presenter

import android.os.AsyncTask
import me.ssangwoo.kotlinlecture.data.source.image.ImageRepository
import me.ssangwoo.kotlinlecture.util.random
import me.ssangwoo.kotlinlecture.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by 쌍우 on 2018-02-26.
 */
class HomePresenter(val view: HomeContract.View,
                    private val imageRepository: ImageRepository,
                    private val imageRecyclerModel: ImageRecyclerModel) : HomeContract.Presenter {

    override fun loadImage() {
        ImageAsyncTask(view, imageRepository, imageRecyclerModel).execute()
    }

    class ImageAsyncTask(val view: HomeContract.View,
                         private val imageRepository: ImageRepository,
                         private val imageRecyclerModel: ImageRecyclerModel) : AsyncTask<Unit, Unit, Unit>() {

        override fun onPreExecute() {
            super.onPreExecute()

            view.showProgress()
        }

        override fun doInBackground(vararg p0: Unit?) {
            imageRepository.loadImageList({
                it.forEach {
                    imageRecyclerModel  .addItem(it)
                }
            }, 5)
            Thread.sleep(1000)
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
//            view.hideProgress()

//            result?.let {
//                view.showImage(it)
//            }

//            imageRepository.loadImageFileName {
//                view.showImage(it)
//            }

            imageRecyclerModel.notifyImageDataSetChange()
            view.hideProgress()
        }
    }
}