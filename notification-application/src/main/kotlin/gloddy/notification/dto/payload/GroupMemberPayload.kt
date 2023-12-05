package gloddy.notification.dto.payload

data class GroupMemberPayload (
    val groupId: Long,
    val captainId: Long,
    val groupMemberName: String,
    val groupImage: Long
)