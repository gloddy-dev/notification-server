package gloddy.notification.event

import gloddy.notification.Notification
import gloddy.notification.NotificationType
import gloddy.notification.UserId

fun Notification.toNotificationCreateEvent(): NotificationCreateEvent =
    NotificationCreateEvent(
        userId = this.userId,
        redirectId = this.redirectId,
        type = this.type
    )

class NotificationCreateEvent(
    val userId: UserId,
    val redirectId: Long,
    val type: NotificationType
) : NotificationEvent