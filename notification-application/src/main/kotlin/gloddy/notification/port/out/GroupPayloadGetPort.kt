package gloddy.notification.port.out

import gloddy.notification.UserId
import gloddy.notification.dto.GroupPayloadDto

interface GroupPayloadGetPort {
    fun get(userId: UserId): GroupPayloadDto
}