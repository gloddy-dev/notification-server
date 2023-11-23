package gloddy.notification

enum class NotificationType(
    val content: String
) {
    APPLY_APPROVE("Your applied gathering has been approved! \uD83D\uDC4C"),
    APPLY_REFUSE("The gathering you applied for has been declined. \uD83E\uDD72"),
    APPLY_CREATE("A new gathering application has arrived!  \uD83D\uDC8C"),
    GROUP_LEAVE("has just left the group.  \uD83E\uDD72"),
    GROUP_ARTICLE_CREATE("Please Check the New Notice! \uD83D\uDDE3"),
    GROUP_APPROACHING_START("The gathering starts in 1 hour! ⏰"),
    GROUP_END("Did you enjoy the gathering? \uD83D\uDE06")
    ;

    companion object {
        fun of(type: String): NotificationType {
            return values().firstOrNull { it.name == type }
                ?: throw RuntimeException("존재하지 않는 Notification 유형 입니다.")
        }
    }

    fun getContent(name: String = "member"): String {
        return when(this) {
            in listOf(GROUP_LEAVE) -> "${name} ${content}"
            else -> content
        }
    }
}