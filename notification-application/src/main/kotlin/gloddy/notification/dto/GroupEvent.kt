package gloddy.notification.dto

import gloddy.notification.GroupEventType
import gloddy.notification.GroupId
import gloddy.notification.UserId

class GroupEvent(
    val userId: UserId,
    val groupId: GroupId,
    val eventType: GroupEventType
)