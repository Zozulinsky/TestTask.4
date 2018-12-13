package zo.den.testtask4.presentation.model

import android.content.ClipData
import android.os.Message
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import zo.den.testtask4.data.network.pojo.Item

data class RssModel(
        val title_rss: String,
        val title_content: String,
        val message: List<Item>
)