package gloddy.notification.dto.event

import gloddy.notification.dto.event.eventType.GroupArticleEventType
import java.time.LocalDateTime

data class GroupArticleEvent(
    val articleId: Long,
    val eventType: GroupArticleEventType,
    val eventDateTime: LocalDateTime
)
