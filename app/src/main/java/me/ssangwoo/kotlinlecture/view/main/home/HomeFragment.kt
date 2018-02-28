package me.ssangwoo.kotlinlecture.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_kotlin_recycler_view.*
import kotlinx.android.synthetic.main.fragment_home.*
import me.ssangwoo.kotlinlecture.R
import me.ssangwoo.kotlinlecture.data.source.image.ImageRepository
import me.ssangwoo.kotlinlecture.view.main.home.adapter.ImageRecyclerAdapter
import me.ssangwoo.kotlinlecture.view.main.home.presenter.HomeContract
import me.ssangwoo.kotlinlecture.view.main.home.presenter.HomePresenter

/**
 * Created by 쌍우 on 2018-02-23.
 */
class HomeFragment: Fragment(), HomeContract.View {

    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment, ImageRepository, imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@HomeFragment.context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
        =  inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
        }
    }

    override fun showImage(imageName: String) {
        imageView.setImageResource(resources.getIdentifier(imageName, "drawable", context.packageName))
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }
}