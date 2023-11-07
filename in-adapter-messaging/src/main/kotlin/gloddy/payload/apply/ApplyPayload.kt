package gloddy.payload.apply

data class ApplyPayload (
    val userId: Long,
    val groupId: Long,
    val applyId: Long,
    val eventType: ApplyPayloadType
)
