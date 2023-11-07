package gloddy.payload.apply

data class ApplyEvent (
    val userId: Long,
    val groupId: Long,
    val applyId: Long,
    val eventType: ApplyEventType
)
