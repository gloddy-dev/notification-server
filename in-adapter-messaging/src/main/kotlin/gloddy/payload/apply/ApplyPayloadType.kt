package gloddy.payload.apply

enum class ApplyPayloadType(
    val description: String
) {
    APPLY_CREATE("지원서가 생성 되었을 때"),
    APPLY_APPROVE("지원서가 승인 처리 되었을 때"),
    APPLY_REFUSE("지원서가 거절 처리 되었을 때")
}