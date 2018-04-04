package milunas.giftadvice.provider

import com.google.gson.Gson
import milunas.giftadvice.model.Group
import milunas.giftadvice.model.User
import okhttp3.*


object UserProvider {

    fun loadData(url: String): List<Group> {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        val response =  client.newCall(request).execute()
        val responseBody = response.body()?.string()
        return Gson()
                .fromJson(responseBody, Array<Group>::class.java)
                .asList()
    }

    fun goIn(user: User) : Response {
        val url = "http://10.0.2.2:8080/user"
        val client = OkHttpClient()
        val mediaType = MediaType.parse("application/json")
        val jsonGroup = Gson().toJson(user)
        val requestBody = RequestBody.create(mediaType, jsonGroup)
        val request = Request.Builder().url(url).post(requestBody).build()
        return client.newCall(request).execute()
    }

    fun addNewGroup(url: String, groupBody : Group) : Response {
        val client = OkHttpClient()
        val mediaType = MediaType.parse("application/json")
        val jsonGroup = Gson().toJson(groupBody)
        val requestBody = RequestBody.create(mediaType, jsonGroup)
        val request = Request.Builder().url(url).post(requestBody).build()
        return client.newCall(request).execute()
    }
}