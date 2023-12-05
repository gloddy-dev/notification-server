package gloddy.notification.dto

import gloddy.notification.dto.eventType.GroupArticleEventType
import java.time.LocalDateTime

data class GroupArticleEvent(
    val articleId: Long,
    val eventType: GroupArticleEventType,
    val eventDateTime: LocalDateTime
)
