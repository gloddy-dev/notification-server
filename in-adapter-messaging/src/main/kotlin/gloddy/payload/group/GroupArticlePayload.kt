package gloddy.payload.group

data class GroupArticlePayload(
    val userId: Long,
    val groupId: Long,
    val groupMemberUserIds: List<Long>,
    val articleId: Long,
    val eventType: GroupArticlePayloadType
)