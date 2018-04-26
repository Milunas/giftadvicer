package milunas.giftadvice.network

import io.reactivex.Observable
import milunas.giftadvice.model.Group
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @GET("/mock/user")
    fun getGroups(): Observable<List<Group>>

    @POST("/mock/user")
    fun postGroup()
}