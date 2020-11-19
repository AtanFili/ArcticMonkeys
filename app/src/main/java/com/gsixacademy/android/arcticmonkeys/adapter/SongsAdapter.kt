package com.gsixacademy.android.arcticmonkeys.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.arcticmonkeys.R
import com.gsixacademy.android.arcticmonkeys.fragments.SongData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list.view.*

class SongsAdapter (
    val songDatas:ArrayList<SongData?>,
    val songDatasClickEvent:(SongsDataClickEvent.SongsDataItemClicked)->Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.fragment_list,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return songDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder=holder as MyViewHolder
        myViewHolder.bindData(songDatas[position], position)
    }
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun bindData(songData:SongData?,position: Int){

            itemView.song_number_tv.text=songData?.number
            itemView.songTitle_tv.text=songData?.name
            itemView.songtimeInput_TV.text=songData?.duration
            Picasso.get().load(songData?.image).fit().into(itemView.songIV)
            itemView.layout_list_fragment.setOnClickListener {
                songDatasClickEvent.invoke(SongsDataClickEvent.SongsDataItemClicked(songData

                )
                )
            }


        }
    }
}
