package gloddy.notification

import java.util.*


@JvmInline
value class UserId(val value: Long)

@JvmInline
value class NotificationId(val value: String)

data class Notification(
    val id: NotificationId = NotificationId(UUID.randomUUID().toString()),
    val userId: UserId,
    val redirectId: Long,
    val title: String,
    val content: String,
    val type: NotificationType
)