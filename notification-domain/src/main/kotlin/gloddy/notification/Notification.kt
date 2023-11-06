package gloddy.notification

@JvmInline
value class GroupId(val value: Long)
@JvmInline
value class UserId(val value: Long)
data class Notification(
    val userId: UserId,
    val groupId: GroupId,
    val content: String,
    val type: NotificationType
)