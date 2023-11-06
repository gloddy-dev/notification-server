package gloddy.notification.dto

import gloddy.notification.GroupId
import gloddy.notification.UserId

data class ApplyPayloadDto(
    val userId: UserId,
    val groupId: GroupId
)