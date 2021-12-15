package com.turicticapp.dccomic.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.turicticapp.dccomic.data.SuperheroeRepository
import com.turicticapp.dccomic.models.Superheroe
import com.turicticapp.dccomic.models.SuperheroeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel(){

    private var superheroesLoad : MutableLiveData<ArrayList<SuperheroeItem>> = MutableLiveData()
    val onSuperheroesLoad : LiveData<ArrayList<SuperheroeItem>> = superheroesLoad

    private val repository = SuperheroeRepository()

    fun getSuperheroeFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
        superheroesLoad.postValue(repository.getSuperheroes())
        }
    }

    fun loadMockSuperheroesFromJson(superHeroesString: InputStream?){
        val superHeroesString = superHeroesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        superheroesLoad.value = gson.fromJson(superHeroesString, Superheroe::class.java)
    }



}