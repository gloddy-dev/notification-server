package gloddy.notification.dto

import gloddy.notification.GroupEventType
import gloddy.notification.UserId

data class GroupEvent(
    val userId: UserId,
    val groupId: Long,
    val eventType: GroupEventType
)