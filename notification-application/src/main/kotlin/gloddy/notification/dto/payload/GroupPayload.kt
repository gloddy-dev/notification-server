package gloddy.notification.dto.payload

data class GroupPayload(
    val groupId: Long,
    val captainId: Long,
    val groupImage: String,
    val groupMemberIds: GroupMemberIds
)