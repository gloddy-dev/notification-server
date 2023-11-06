package gloddy.notification.dto

import gloddy.notification.ApplyEventType
import gloddy.notification.GroupId
import gloddy.notification.UserId

class ApplyEvent(
    val userId: UserId,
    val groupId: GroupId,
    val eventType: ApplyEventType
)