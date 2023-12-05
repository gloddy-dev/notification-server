package gloddy.notification.dto.payload

data class GroupArticlePayload(
    val groupId: Long,
    val captainId: Long,
    val writerId: Long,
    val groupImage: String,
    val groupMemberIds: GroupMemberIds
)


