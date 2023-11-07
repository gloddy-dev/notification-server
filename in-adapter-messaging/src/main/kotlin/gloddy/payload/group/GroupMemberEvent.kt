package gloddy.payload.group

data class GroupMemberEvent(
    val userId: Long,
    val groupId: Long,
    val eventType: GroupMemberEventType
)