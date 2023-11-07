package gloddy.payload.group

data class GroupMemberPayload(
    val userId: Long,
    val groupId: Long,
    val eventType: GroupMemberPayloadType
)