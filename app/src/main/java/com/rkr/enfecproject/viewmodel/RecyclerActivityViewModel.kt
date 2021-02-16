package com.rkr.enfecproject.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rkr.enfecproject.model.RetroPosts
import com.rkr.enfecproject.model.RetroUsers
import com.rkr.enfecproject.network.RetroInstance
import com.rkr.enfecproject.network.RetroService
import com.rkr.mixproject.RVAdapter
import retrofit2.Call
import retrofit2.Response

class RecyclerActivityViewModel : ViewModel() {


    lateinit var recyclerUsersData: MutableLiveData<List<RetroUsers>>
    lateinit var recyclerPostData: MutableLiveData<List<RetroPosts>>

    init {
        recyclerUsersData = MutableLiveData()
        recyclerPostData = MutableLiveData()
    }

    fun getRecyclerListUserObserver(): MutableLiveData<List<RetroUsers>> {
        return recyclerUsersData
    }

    fun getRecyclerListPostObserver(): MutableLiveData<List<RetroPosts>> {
        return recyclerPostData
    }

    fun makeUserAPICall() {

        val service: RetroService =
            RetroInstance.getRetroInstanceUsers().create(RetroService::class.java)
        val call: Call<List<RetroUsers>> = service.getAllUsers()
        call.enqueue(object : retrofit2.Callback<List<RetroUsers>> {

            override fun onResponse(
                call: Call<List<RetroUsers>>,
                response: Response<List<RetroUsers>>
            ) =
                if (response?.isSuccessful!!) {
                    recyclerUsersData.postValue(response.body())
                    // response.body()?.let { loadDataList(it) }
                    var i: Int = 6
                } else {
                    recyclerUsersData.postValue(null)
                }

            override fun onFailure(call: Call<List<RetroUsers>>, t: Throwable) {
                var i: Int = 6
            }
        })
    }

    fun makePostsAPICall() {

        val service: RetroService =
            RetroInstance.getRetroInstancePost().create(RetroService::class.java)
        val call: Call<List<RetroPosts>> = service.getAllPosts()
        call.enqueue(object : retrofit2.Callback<List<RetroPosts>> {

            override fun onResponse(
                call: Call<List<RetroPosts>>,
                response: Response<List<RetroPosts>>
            ) =
                if (response?.isSuccessful!!) {
                    recyclerPostData.postValue(response.body())
                    // response.body()?.let { loadDataList(it) }
                    var i: Int = 6
                } else {
                    recyclerUsersData.postValue(null)
                }

            override fun onFailure(call: Call<List<RetroPosts>>, t: Throwable) {
                var i: Int = 6
            }
        })
    }


}




