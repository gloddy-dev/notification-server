package gloddy.notification


@JvmInline
value class UserId(val value: Long)

data class Notification(
    val userId: UserId,
    val redirectId: Long,
    val content: String,
    val type: NotificationType
)