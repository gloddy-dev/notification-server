package gloddy.payload.group

import java.time.LocalDateTime

data class GroupPayload(
    val groupId: Long,
    val eventType: GroupPayloadType,
    val eventDateTime: LocalDateTime
)