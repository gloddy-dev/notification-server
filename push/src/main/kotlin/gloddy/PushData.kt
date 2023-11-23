package gloddy

data class PushCommand(
    val token: String,
    val title: String,
    val content: String,
    val payload: Map<String, String>
)