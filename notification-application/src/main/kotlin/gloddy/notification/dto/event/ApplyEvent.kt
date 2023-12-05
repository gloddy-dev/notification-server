package gloddy.notification.dto

import gloddy.notification.dto.eventType.ApplyEventType
import gloddy.notification.UserId
import java.time.LocalDateTime

data class ApplyEvent(
    val userId: UserId,
    val eventType: ApplyEventType,
    val eventDateTime: LocalDateTime
)