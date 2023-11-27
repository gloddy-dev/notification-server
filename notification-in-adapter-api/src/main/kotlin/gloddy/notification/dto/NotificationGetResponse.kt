package gloddy.notification.dto

import gloddy.notification.Notification
import gloddy.notification.NotificationType
import gloddy.notification.UserId

data class NotificationGetResponse(
    val notifications: List<NotificationDto>
)

data class NotificationDto(
    val userId: UserId,
    val redirectId: Long,
    val title: String,
    val content: String,
    val type: NotificationType
)

fun List<Notification>.toResponse(): NotificationGetResponse =
    NotificationGetResponse(
        this.map { it.toDto() }.toList()
    )

fun Notification.toDto(): NotificationDto =
    NotificationDto(
        userId = this.userId,
        redirectId = this.redirectId,
        title = this.title,
        content = this.content,
        type = this.type
    )