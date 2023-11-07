package gloddy.dynamodb.notification

import gloddy.notification.Notification
import gloddy.notification.UserId


fun NotificationEntity.toDomain(): Notification =
    Notification(
        userId = UserId(this.userId.toLong()),
        redirectId = this.redirectId.toLong(),
        content = this.content,
        type = this.type!!
    )

fun Notification.toEntity(): NotificationEntity =
    NotificationEntity(
        userId = this.userId.value.toString(),
        redirectId = this.redirectId.toString(),
        content = this.content,
        type = this.type
    )