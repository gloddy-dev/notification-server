package gloddy.notification

import java.time.LocalDateTime
import java.util.*


@JvmInline
value class UserId(val value: Long)

@JvmInline
value class RedirectId(val value: Long)

@JvmInline
value class NotificationId(val value: String)

data class Notification(
    val id: NotificationId? = NotificationId(UUID.randomUUID().toString()),
    val userId: UserId,
    val redirectId: RedirectId,
    val title: String,
    val content: String,
    val type: NotificationType,
    val image: String,
    val createdAt: LocalDateTime? = LocalDateTime.now()
)