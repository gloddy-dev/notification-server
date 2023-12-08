package gloddy.notification.dto

import gloddy.notification.Notification
import gloddy.notification.NotificationType
import gloddy.notification.RedirectId
import gloddy.notification.UserId

data class NotificationGetResponse(
    val notifications: List<NotificationDto>
)

data class NotificationDto(
    val userId: UserId,
    val redirectId: RedirectId,
    val title: String,
    val content: String,
    val type: NotificationType,
    val createdAt: String,
    val image: String
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
        type = this.type,
        createdAt = this.createdAt.toString(),
        image = this.image
    )