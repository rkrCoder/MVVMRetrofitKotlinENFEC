package com.rkr.mixproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rkr.enfecproject.R
import com.rkr.enfecproject.model.MixedUser
import kotlinx.android.synthetic.main.rv_row.view.*

class RVAdapter : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tv_company = view.tv_company
        var tv_title = view.tv_title
        var tv_body = view.tv_body


        fun bind(xx: MixedUser) {

            tv_company.text = xx.cname
            tv_title.text=xx.title
            tv_body.text=xx.body

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listMixedUser.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listMixedUser[position])
    }

    fun setListData(data: ArrayList<MixedUser>) {
        this.listMixedUser = data
    }

    var listMixedUser= ArrayList<MixedUser>()


}