package gloddy.notification.event

import gloddy.notification.NotificationType
import gloddy.notification.UserId

class NotificationPushEvent(
    val userId: UserId,
    val content: String,
    val type: NotificationType,
    val redirectId: Long
)