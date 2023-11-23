package gloddy.command

import gloddy.notification.UserId

data class GroupingPushCommand(
    override val userId: UserId,
    override val content: String,
    override val payload: Map<String, String>,
    override val isRequirePush: Boolean
) : PushCommand