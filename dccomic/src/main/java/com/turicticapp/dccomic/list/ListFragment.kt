package com.turicticapp.dccomic.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.turicticapp.dccomic.databinding.FragmentListBinding
import com.turicticapp.dccomic.main.MainActivity
import com.turicticapp.dccomic.models.Superheroe
import com.turicticapp.dccomic.models.SuperheroeItem


class ListFragment : Fragment() {
    private  var listSuperheroes : ArrayList<SuperheroeItem> = arrayListOf()
    private lateinit var listBinding : FragmentListBinding
    private lateinit var listViewModel : ListViewModel
    private lateinit var superHeroesAdapter : SuperHeroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockSuperheroesFromJson(context?.assets?.open("superheroes.json"))
        listViewModel.onSuperheroesLoad.observe(viewLifecycleOwner, { result ->
            onSuperheroeLoaderSubscribe(result)
        })


        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes,onItemClicked = {onSuperheroeClicked(it)})
        listBinding.superheroeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSuperheroeLoaderSubscribe(result: ArrayList<SuperheroeItem>?) {
        result?.let{ listSuperheroes ->
            superHeroesAdapter.appendItems(listSuperheroes)
        }
    }

    private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe=superheroe))

    }
    /*
    private fun loadMockSuperheroesFromJson(): ArrayList<SuperheroeItem> {

        val superHeroesString : String = context?.assets?.open("superheroes.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(superHeroesString, Superheroe::class.java)
        return data

    }*/

}