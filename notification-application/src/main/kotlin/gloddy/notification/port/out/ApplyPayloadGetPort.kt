package gloddy.notification.port.out

import gloddy.notification.dto.ApplyPayloadDto

interface ApplyPayloadGetPort {
    fun get(applyId: Long): ApplyPayloadDto
}