package gloddy.notification.event

import gloddy.notification.Notification

class NotificationCreateNotificationEvent(
    val notification: Notification
) : NotificationEvent

//fun Notification.toEntity(): NotificationPushEvent =
//    NotificationPushEvent(
//        userId = this.userId,
//        content = this.content,
//        type = this.type,
//        redirectId = this.redirectId
//    )