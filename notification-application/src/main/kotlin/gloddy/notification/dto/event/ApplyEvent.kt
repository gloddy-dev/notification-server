package gloddy.notification.dto.event

import gloddy.notification.dto.event.eventType.ApplyEventType
import java.time.LocalDateTime

data class ApplyEvent (
    val applyId: Long,
    val eventType: ApplyEventType,
    val eventDateTime: LocalDateTime
)