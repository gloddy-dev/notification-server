package gloddy.payload.group

import java.time.LocalDateTime

data class GroupArticlePayload(
    val articleId: Long,
    val eventType: GroupArticlePayloadType,
    val eventDateTime: LocalDateTime
)