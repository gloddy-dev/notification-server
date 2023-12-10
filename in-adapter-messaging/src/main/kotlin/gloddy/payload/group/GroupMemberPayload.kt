package gloddy.payload.group

import java.time.LocalDateTime

data class GroupMemberPayload(
    val userId: Long,
    val groupId: Long,
    val eventType: GroupMemberPayloadType,
    val eventDateTime: LocalDateTime
)