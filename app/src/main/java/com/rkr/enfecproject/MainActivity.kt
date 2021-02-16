package com.rkr.enfecproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rkr.enfecproject.model.MixedUser
import com.rkr.enfecproject.model.RetroPosts
import com.rkr.enfecproject.model.RetroUsers
import com.rkr.enfecproject.viewmodel.RecyclerActivityViewModel
import com.rkr.mixproject.RVAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var rvAdapter: RVAdapter
    var listMixedUser = ArrayList<MixedUser>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRV()
        createData()
    }

    private fun initRV() {
        rv_.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            rvAdapter = RVAdapter()
            adapter = rvAdapter


            val decoration =
                DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }

    fun createData() {

        val viewModel = ViewModelProviders.of(this).get(RecyclerActivityViewModel::class.java)
        viewModel.makeUserAPICall()
        viewModel.makePostsAPICall()

        viewModel.getRecyclerListUserObserver().observe(this, Observer<List<RetroUsers>> {
            if (it != null) {
                checkSimilaity(viewModel, it)
            } else {
                Toast.makeText(this@MainActivity, "Error in fetchinng from API", Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

    private fun checkSimilaity(
        viewModel: RecyclerActivityViewModel,
        xx: List<RetroUsers>
    ) {
        viewModel.getRecyclerListPostObserver().observe(this, Observer<List<RetroPosts>> {
            if (it != null) {
                for (user in xx) {
                    for (post in it) {
                        if (user.id == post.id) {
                            var mixedUser = MixedUser(user.company.name, post.title, post.body)
                            listMixedUser.add(mixedUser)
                        }
                    }

                }
                rvAdapter.setListData(listMixedUser)
                rvAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this@MainActivity, "Error in fetchinng from API", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}