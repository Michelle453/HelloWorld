package com.turicticapp.dccomic.data

class SuperheroeRepository {

    suspend fun getSuperheroes() = WebService.retrofit.getSuperheroes()
}