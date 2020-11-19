package com.gsixacademy.android.arcticmonkeys.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.arcticmonkeys.MainActivity
import com.gsixacademy.android.arcticmonkeys.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.botom_navigation.*
import kotlinx.android.synthetic.main.song_details.*

class DetailsFragment:Fragment() {
    var songList:SongModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.song_details,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        songList=(activity as MainActivity).songModel
        val songNumber=arguments?.getString("songNumber")?:""
        val songName=arguments?.getString("songName")?:""
        val duration=arguments?.getString("duration")?:""
        val image=arguments?.getString("image")?:""

        song_number_details.text=songNumber
        song_title.text=songName
        Picasso.get().load(image).into(songImage_details)






    }








}