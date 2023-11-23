package gloddy

data class PushData(
    val token: String,
    val title: String,
    val content: String,
    val payload: Map<String, String>
)