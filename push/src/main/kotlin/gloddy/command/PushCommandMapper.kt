package gloddy.command

import gloddy.notification.event.NotificationCreateEvent

fun NotificationCreateEvent.toGroupingPushCommand(name: String? = "member"): PushCommand {
    val pushType = GroupingPushType.from(this.type)

    return GroupingPushCommand(
        userId = this.userId,
        title = pushType.title(name),
        content = pushType.content,
        payload = mapOf(
            "redirectId" to this.redirectId.value.toString(),
            "type" to pushType.name
        ),
        pushType.isRequiredPush
    )
}
