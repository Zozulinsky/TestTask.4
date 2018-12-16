package zo.den.testtask4.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LinkDataEntity (
        val id : Int?,
        var name: String,
        var link: String
):Parcelable