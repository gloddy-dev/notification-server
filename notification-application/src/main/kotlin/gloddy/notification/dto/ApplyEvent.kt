package gloddy.notification.dto

import gloddy.notification.ApplyEventType
import gloddy.notification.UserId

data class ApplyEvent(
    val userId: UserId,
    val applyGroupId: Long,
    val applyUserId: UserId,
    val eventType: ApplyEventType
)