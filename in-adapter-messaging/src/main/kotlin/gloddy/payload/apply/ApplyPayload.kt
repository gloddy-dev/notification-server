package gloddy.payload.apply

data class ApplyPayload (
    val userId: Long,
    val applyGroupId: Long,
    val applyUserId: Long,
    val eventType: ApplyPayloadType
)
