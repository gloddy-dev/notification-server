package gloddy.notification.dto.event

import gloddy.notification.dto.event.eventType.GroupMemberEventType
import java.time.LocalDateTime

data class GroupMemberEvent(
    val groupMemberId: Long,
    val eventType: GroupMemberEventType,
    val eventDateTime: LocalDateTime
)
