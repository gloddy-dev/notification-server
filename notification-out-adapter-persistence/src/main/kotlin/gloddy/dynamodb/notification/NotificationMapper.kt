package gloddy.dynamodb.notification

import gloddy.notification.Notification
import gloddy.notification.NotificationId
import gloddy.notification.RedirectId
import gloddy.notification.UserId


fun NotificationEntity.toDomain(): Notification =
    Notification(
        id = NotificationId(this.id),
        userId = UserId(this.userId.toLong()),
        redirectId = RedirectId(this.redirectId.toLong()),
        title = this.title,
        content = this.content,
        type = this.type!!,
        image = this.image,
        createdAt = this.createdAt
    )

fun Notification.toEntity(): NotificationEntity =
    NotificationEntity(
        userId = this.userId.value.toString(),
        redirectId = this.redirectId.value.toString(),
        title = this.title,
        content = this.content,
        type = this.type,
        image = this.image
    )