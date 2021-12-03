package com.turicticapp.dccomic.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.turicticapp.dccomic.R
import com.turicticapp.dccomic.models.SuperheroeItem

class SuperHeroesAdapter(
    private val superHeroesList:ArrayList<SuperheroeItem>,
    private val onItemClicked:(SuperheroeItem) -> Unit
    ) :RecyclerView.Adapter<SuperHeroesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_superheroe_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superheroe = superHeroesList[position]
        holder.itemView.setOnClickListener{onItemClicked(superHeroesList[position])}
        holder.bind(superheroe)
    }

    override fun getItemCount(): Int {
        return superHeroesList.size

    }

    fun appendItems(newItems : ArrayList<SuperheroeItem>) {
        superHeroesList.clear()
        superHeroesList.addAll(newItems)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        private var nameTextView : TextView = itemView.findViewById(R.id.name_text_view)
        private var aliasTextView : TextView = itemView.findViewById(R.id.alias_text_view)
        private var pictureImageView : ImageView = itemView.findViewById(R.id.picture_image_view)
        fun bind(superheroe : SuperheroeItem){
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }
    }
}