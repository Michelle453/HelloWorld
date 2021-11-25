package com.example.helloworld.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworld.R
import com.example.helloworld.databinding.ActivityMainBinding
import com.example.helloworld.models.SuperheroeItem
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var detalleBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)
        //setContentView(R.layout.activity_main)

        val superheroe: SuperheroeItem = intent.extras?.getSerializable("superheroe") as SuperheroeItem

        with(detalleBinding){
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            cityTextView.text = superheroe.city
            occupationTextView.text = superheroe.occupation
            //heightTextView.text = superheroe.height.toString()
            facebookTextView.text = superheroe.facebook
            powersTextView.text = superheroe.powers
            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
    }

}
}
