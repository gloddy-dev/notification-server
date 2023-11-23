package gloddy.command

import gloddy.notification.event.NotificationCreateEvent

fun NotificationCreateEvent.toGroupingPushCommand(name: String = "member"): PushCommand {

    val pushType = GroupingPushType.from(this.type)

    return GroupingPushCommand(
        userId = this.userId,
        content = pushType.getContent(name),
        payload = buildMap {
            put("redirectId", this@toGroupingPushCommand.redirectId.toString())
            put("type", pushType.name)
        },
        pushType.isRequiredPush
    )
}
