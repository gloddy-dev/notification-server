package gloddy.payload.group

import java.time.LocalDateTime

data class GroupMemberPayload(
    val groupMemberId: Long,
    val eventType: GroupMemberPayloadType,
    val eventDateTime: LocalDateTime
)