package com.gsixacademy.android.arcticmonkeys.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.arcticmonkeys.MainActivity
import com.gsixacademy.android.arcticmonkeys.R
import com.gsixacademy.android.arcticmonkeys.adapter.SongsAdapter
import com.gsixacademy.android.arcticmonkeys.adapter.SongsDataClickEvent
import kotlinx.android.synthetic.main.recycler_songs.*

class ListFragment:Fragment() {
    lateinit var songsAdapter:SongsAdapter
    var songList:SongModel?=null





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_songs,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        val songSelected=arguments?.getString("songsSelected")
    }
    private fun initRecyclerView(){
        val sonsModel=(activity as MainActivity).songModel
        songsAdapter= SongsAdapter(sonsModel?.song!!){
            if(it is SongsDataClickEvent.SongsDataItemClicked){

                var bundle=Bundle()
                bundle.putString("songNumber",it.songData?.number)
                bundle.putString("songName",it.songData?.name)
                bundle.putString("duration",it.songData?.duration)
                bundle.putString("image",it.songData?.image)
                findNavController().navigate(R.id.action_listFragment_to_detailsFragment)


            }
        }

      recycler_songs.adapter=songsAdapter



    }
}