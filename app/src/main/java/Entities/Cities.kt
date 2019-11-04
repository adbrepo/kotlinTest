package Entities

import android.os.Parcel
import android.os.Parcelable

class Cities(title: String, backgroundImageUrl: String) : Parcelable {
    private var title: String? = null

    private var backgroundImageUrl: String? = null

    init {
        this.title = title
        this.backgroundImageUrl = backgroundImageUrl
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(backgroundImageUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Cities> = object : Parcelable.Creator<Cities> {
            override fun createFromParcel(source: Parcel): Cities = Cities(source)
            override fun newArray(size: Int): Array<Cities?> = arrayOfNulls(size)
        }
    }
}