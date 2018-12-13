package zo.den.testtask4.presentation.model

import zo.den.testtask4.data.network.pojo.Channel

data class RssModel(
        val title_rss: String,
        val title_content: String,
        val message: List<Channel.Item>
)