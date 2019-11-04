package Entities

import Entities.Enums.AgeType
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.IntDef

class User(name: String, pass: String) : Parcelable {

    var name: String = ""
    var pass: String = ""
    var age : Int = 0

    init {
        this.name = name
        this.pass = pass
        this.age = AgeType.FAST
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(pass)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}