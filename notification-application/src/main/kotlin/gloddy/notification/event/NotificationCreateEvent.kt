package gloddy.notification.event

import gloddy.notification.Notification
import gloddy.notification.NotificationType
import gloddy.notification.RedirectId
import gloddy.notification.UserId

fun Notification.toNotificationCreateEvent(): NotificationCreateEvent =
    NotificationCreateEvent(
        userId = this.userId,
        redirectId = this.redirectId,
        type = this.type
    )

class NotificationCreateEvent(
    val userId: UserId,
    val redirectId: RedirectId,
    val type: NotificationType
) : NotificationEvent