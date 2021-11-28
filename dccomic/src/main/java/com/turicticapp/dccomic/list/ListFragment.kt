package com.turicticapp.dccomic.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.turicticapp.dccomic.databinding.FragmentListBinding
import com.turicticapp.dccomic.main.MainActivity
import com.turicticapp.dccomic.models.Superheroe
import com.turicticapp.dccomic.models.SuperheroeItem


class ListFragment : Fragment() {
    private lateinit var listSuperheroes : ArrayList<SuperheroeItem>
    private lateinit var listBinding : FragmentListBinding
    private lateinit var superHeroesAdapter : SuperHeroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listSuperheroes = loadMockSuperheroesFromJson()
        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes,onItemClicked = {onSuperheroeClicked(it)})
        listBinding.superheroeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroesAdapter
            setHasFixedSize(false)
        }
    }
    private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe=superheroe))

    }
    private fun loadMockSuperheroesFromJson(): ArrayList<SuperheroeItem> {

        val superHeroesString : String = context?.assets?.open("superheroes.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(superHeroesString, Superheroe::class.java)
        return data

    }

}