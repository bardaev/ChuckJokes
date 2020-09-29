package com.example.chuckjokes.rest.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JokeItem: Parcelable {
    constructor()

    constructor(i: Parcel) {
        joke = i.readString()
    }

    @SerializedName("joke")
    @Expose
    var joke: String? = null

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(joke)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<JokeItem> = object : Parcelable.Creator<JokeItem> {
            override fun createFromParcel(source: Parcel?): JokeItem {
                return JokeItem(source!!)
            }

            override fun newArray(size: Int): Array<JokeItem?> {
                return arrayOfNulls(size)
            }

        }
    }
}