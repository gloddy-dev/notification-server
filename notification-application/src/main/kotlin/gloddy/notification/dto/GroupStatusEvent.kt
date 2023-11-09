package gloddy.notification.dto

import gloddy.notification.UserId

data class GroupStatusEvent(
    val groupId: Long,
    val groupMemberUserIds: List<UserId>,
    val eventType: GroupStatusEventType
)
