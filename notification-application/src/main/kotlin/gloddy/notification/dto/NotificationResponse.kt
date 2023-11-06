package gloddy.notification.dto

import gloddy.notification.GroupId
import gloddy.notification.Notification
import gloddy.notification.UserId

data class NotificationResponse(
    val notifications: List<NotificationDto>
)

data class NotificationDto(
    val userId: UserId,
    val groupId: GroupId,
    val content: String
)

fun List<Notification>.toResponse(): NotificationResponse =
    NotificationResponse(
        this.map { it.toDto() }.toList()
    )

fun Notification.toDto(): NotificationDto =
    NotificationDto(
        userId = this.userId,
        groupId = this.groupId,
        content = this.content
    )