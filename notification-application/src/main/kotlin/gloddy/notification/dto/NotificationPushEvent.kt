package gloddy.notification.dto

class NotificationPushEvent(
    val token: String,
    val content: String,
    val payload: Map<String, String>
)