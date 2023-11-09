package gloddy.notification

enum class NotificationType(
    val content: String,
    val isNotificationRequired: Boolean
) {
    APPLY_APPROVE("지원하신 모임이 승인되었어요! 모임 고지를 확인해주세요", true),
    APPLY_REFUSE("지원하신 모임이 거절되었어요. 다른 모임을 찾아볼까요?", false),
    APPLY_CREATE("새로운 모임 지원서가 도착했어요!", true),
    GROUP_LEAVE("님이 그룹에서 나갔어요", true),
    GROUP_ARTICLE_CREATE("새로운 게시글을 확인해주세요", true),
    GROUP_APPROACHING_START("""
        1시간 뒤 모임이 시작돼요!
        준비는 되었나요?
    """.trimIndent(), true),
    GROUP_END("""
        모임은 즐거우셨나요?
        함께 했던 인원들을 평가해주세요!
    """.trimIndent(), false)
    ;

    companion object {
        fun of(type: String): NotificationType {
            return values().firstOrNull { it.name == type }
                ?: throw RuntimeException("존재하지 않는 Notification 유형 입니다.")
        }
    }

    fun getContent(name: String): String {
        return when(this) {
            in listOf(GROUP_LEAVE) -> "${name}${content}"
            else -> content
        }
    }
}