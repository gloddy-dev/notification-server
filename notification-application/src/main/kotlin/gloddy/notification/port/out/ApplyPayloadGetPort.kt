package gloddy.notification.port.out

import gloddy.notification.dto.event.eventType.ApplyEventType
import gloddy.notification.dto.payload.ApplyPayload

interface ApplyPayloadGetPort {
    fun getApplyPayload(applyId: Long, eventType: ApplyEventType): ApplyPayload
}