package com.rkr.enfecproject.model

//data class RecyclerList (var items:ArrayList<RetroUsers>)
data class RetroUsers(var id: Int, val company: Company)
data class Company(var name: String)

data class RetroPosts(var id: Int,var title: String,var body: String)

data class MixedUser(var cname: String,var title: String,var body: String)
