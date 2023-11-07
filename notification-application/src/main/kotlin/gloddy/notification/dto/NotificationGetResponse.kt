package gloddy.notification.dto

import gloddy.notification.Notification
import gloddy.notification.NotificationType
import gloddy.notification.UserId

data class NotificationResponse(
    val notifications: List<NotificationDto>
)

data class NotificationDto(
    val userId: UserId,
    val redirectId: Long,
    val content: String,
    val type: NotificationType
)

fun List<Notification>.toResponse(): NotificationResponse =
    NotificationResponse(
        this.map { it.toDto() }.toList()
    )

fun Notification.toDto(): NotificationDto =
    NotificationDto(
        userId = this.userId,
        redirectId = this.redirectId,
        content = this.content,
        type = this.type
    )