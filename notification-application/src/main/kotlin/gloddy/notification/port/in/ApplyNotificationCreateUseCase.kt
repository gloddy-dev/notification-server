package gloddy.notification.port.`in`

import gloddy.notification.dto.event.ApplyEvent

interface ApplyNotificationCreateUseCase {
    fun create(event: ApplyEvent)
}