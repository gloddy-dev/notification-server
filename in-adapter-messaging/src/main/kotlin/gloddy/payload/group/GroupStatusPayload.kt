package gloddy.payload.group

data class GroupStatusPayload(
    val groupId: Long,
    val groupMemberUserIds: List<Long>,
    val eventType: GroupStatusPayloadType
)