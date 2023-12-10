package gloddy.notification.dto.event

import gloddy.notification.UserId
import gloddy.notification.dto.event.eventType.GroupMemberEventType
import java.time.LocalDateTime

data class GroupMemberEvent(
    val userId: UserId,
    val groupId: Long,
    val eventType: GroupMemberEventType,
    val eventDateTime: LocalDateTime
)
