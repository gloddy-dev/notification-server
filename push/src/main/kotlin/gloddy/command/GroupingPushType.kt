package gloddy.command

import gloddy.notification.NotificationType

enum class GroupingPushType(
    val title: String,
    private val content: String,
    val isRequiredPush: Boolean
) {
    APPLY_APPROVE("Your applied gathering has been approved! 👌",
        "Wishing you enjoy a fun and safe gathering.", true),
    APPLY_REFUSE("The gathering you applied for has been declined. \uD83E\uDD72",
        "There are various other gatherings available for you! Would you like to look for another gathering?",
        false),
    APPLY_CREATE("A new gathering application has arrived! 💌",
        "We’re awaiting the host’s approval for the gathering! please warmly welcome the new members.",
        true),
    GROUP_LEAVE("has just left the group.  \uD83E\uDD72",
        "Shall we go check the group participants?",
        true),
    GROUP_ARTICLE_CREATE("Please Check the New Notice! \uD83D\uDDE3",
        "A new post has been added.",
        true),
    GROUP_APPROACHING_START("The gathering starts in 1 hour! ⏰",
        "Are you ready to enjoy the gathering? \n" +
                "Check the announcement for a better gathering!", true),
    GROUP_END("Did you enjoy the gathering? \uD83D\uDE06",
        "Please rate the attendees of the gathering! \n" +
                "Select the best partner with reward stickers.",
        false)
    ;

    companion object {

        fun from(notificationType: NotificationType): GroupingPushType {
            return GroupingPushType.values().firstOrNull { it.name == notificationType.name }
                ?: throw RuntimeException("not found groupingPushType")
        }
    }

    fun getContent(name: String = "member"): String {
        return when(this) {
            in listOf(GROUP_LEAVE) -> "'${name}' ${content}"
            else -> content
        }
    }
}