package com.gsixacademy.android.arcticmonkeys.fragments

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
class SongData():Parcelable {
    var duration:String?=null
    var lyrics:String?=null
    var name:String?=null
    var number:Long?=null
    var tabs:String?=null
    var image:String?=null
    var youtube:String?=null



    constructor(parcel:Parcel):this(){
        duration=parcel.readString()
        lyrics=parcel.readString()
        name=parcel.readString()
        number=parcel.readLong()
        tabs=parcel.readString()
        image=parcel.readString()
        youtube=parcel.readString()
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(duration)
        parcel.writeString(lyrics)
        parcel.writeString(name)
        number?.let { parcel.writeLong(it) }
        parcel.writeString(tabs)
        parcel.writeString(youtube)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR:Parcelable.Creator<SongData>{
        override fun createFromParcel(parcel: Parcel): SongData {
        return SongData(parcel)
        }

        override fun newArray(size: Int): Array<SongData?> {
            return arrayOfNulls(size)
        }
    }

}

