package gloddy.notification.dto.event

import gloddy.notification.dto.event.eventType.GroupEventType
import java.time.LocalDateTime

data class GroupEvent(
    val groupId: Long,
    val eventType: GroupEventType,
    val eventDateTime: LocalDateTime
)