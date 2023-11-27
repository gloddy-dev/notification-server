package gloddy.notification

enum class NotificationType(
    val title: String,
    val content: String
) {
    APPLY_APPROVE(
        "👌Your applied gathering has been approved!",
        "Wishing you enjoy a fun and safe gathering."
    ),
    APPLY_REFUSE(
        "😢The gathering you applied for has been declined.",
        "There are various other gatherings available for you! Would you like to look for another gathering?"
    ),
    APPLY_CREATE(
        "💌A new gathering application has arrived!",
        "We’re awaiting the host’s approval for the gathering! please warmly welcome the new members."
    ),
    GROUP_LEAVE(
        "😢has just left the group.",
        "Shall we go check the group participants?"
    ),
    GROUP_ARTICLE_CREATE(
        "🗣️Please Check the New Notice!",
        "A new post has been added."
    ),
    GROUP_APPROACHING_START(
        "⏰The gathering starts in 1 hour!",
        "Are you ready to enjoy the gathering? \n" + "Check the announcement for a better gathering!"
    ),
    GROUP_END(
        "😆Did you enjoy the gathering?",
        "Please rate the attendees of the gathering! \n" + "Select the best partner with reward stickers."
    )
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