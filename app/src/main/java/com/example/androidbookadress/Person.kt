package com.example.androidbookadress

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Person(
    val firstName: String?,
    val secondName:String?,
    val adress: String?,
    val numPhone:String?
):Parcelable {
    constructor(parcel: Parcel):this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )
    override fun toString() = "$firstName $secondName"
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(firstName)
        dest.writeString(secondName)
        dest.writeString(adress)
        dest.writeString(numPhone)
    }
    companion object CREATOR : Parcelable.Creator<Person>{
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(p0: Int): Array<Person?> {
            return arrayOfNulls(p0)
        }
    }
}