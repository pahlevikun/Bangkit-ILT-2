package id.pahlevikun.ilt2.sample.intent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?,
) : Parcelable {

    companion object {
        val empty = Person(
            name = "",
            age = 0,
            email = "",
            city = ""
        )
    }
/* Uncomment this if you want to use Parcel by manually
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeString(email)
        parcel.writeString(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
*/
}