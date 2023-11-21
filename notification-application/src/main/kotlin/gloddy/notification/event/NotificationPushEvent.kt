package gloddy.notification.event

import gloddy.notification.Notification
import gloddy.notification.NotificationType
import gloddy.notification.UserId

class NotificationPushEvent(
    val notification: Notification
)

//fun Notification.toEntity(): NotificationPushEvent =
//    NotificationPushEvent(
//        userId = this.userId,
//        content = this.content,
//        type = this.type,
//        redirectId = this.redirectId
//    )