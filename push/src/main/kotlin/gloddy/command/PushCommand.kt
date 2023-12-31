package gloddy.command

import gloddy.notification.UserId

interface PushCommand {
    val userId: UserId
    val title: String
    val content: String
    val payload: Map<String, String>
    val isRequirePush: Boolean
}