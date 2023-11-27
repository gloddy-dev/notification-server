package gloddy.dynamodb.notification

import gloddy.notification.Notification
import gloddy.notification.NotificationId
import gloddy.notification.UserId


fun NotificationEntity.toDomain(): Notification =
    Notification(
        id = NotificationId(this.id),
        userId = UserId(this.userId.toLong()),
        redirectId = this.redirectId.toLong(),
        title = this.title,
        content = this.content,
        type = this.type!!
    )

fun Notification.toEntity(): NotificationEntity =
    NotificationEntity(
        id = this.id.value,
        userId = this.userId.value.toString(),
        redirectId = this.redirectId.toString(),
        title = this.title,
        content = this.content,
        type = this.type
    )