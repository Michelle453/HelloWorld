package com.turicticapp.dccomic.data

import com.turicticapp.dccomic.models.Superheroe
import retrofit2.http.GET

interface ApiService {

    @GET("Michelle453/HelloWorld/superheroes")
    suspend fun getSuperheroes(): Superheroe
}