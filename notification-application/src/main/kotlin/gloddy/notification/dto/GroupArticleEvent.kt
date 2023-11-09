package gloddy.notification.dto

import gloddy.notification.UserId

data class GroupArticleEvent(
    val userId: UserId,
    val groupId: Long,
    val groupMemberUserIds: List<UserId>,
    val articleId: Long,
    val eventType: GroupArticleEventType
)
