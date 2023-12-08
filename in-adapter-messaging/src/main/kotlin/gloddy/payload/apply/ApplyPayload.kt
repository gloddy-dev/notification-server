package gloddy.payload.apply

import java.time.LocalDateTime

data class ApplyPayload (
    val applyId: Long,
    val eventType: ApplyPayloadType,
    val eventDateTime: LocalDateTime
)
