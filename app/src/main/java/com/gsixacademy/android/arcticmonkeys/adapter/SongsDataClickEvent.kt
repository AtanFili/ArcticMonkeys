package com.gsixacademy.android.arcticmonkeys.adapter

import com.gsixacademy.android.arcticmonkeys.fragments.SongData

open class SongsDataClickEvent {
     data class SongsDataItemClicked(val songData:SongData?):SongsDataClickEvent()

}
