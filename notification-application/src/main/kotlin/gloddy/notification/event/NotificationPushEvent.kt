package gloddy.notification.event

class NotificationPushEvent(
    val token: String,
    val content: String,
    val payload: Map<String, String>
)