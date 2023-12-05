package gloddy.notification.dto

import gloddy.notification.dto.eventType.GroupMemberEventType
import gloddy.notification.UserId
import gloddy.notification.dto.eventType.GroupEventType
import java.time.LocalDateTime

data class GroupEvent(
    val groupId: Long,
    val eventType: GroupEventType,
    val eventDateTime: LocalDateTime
)