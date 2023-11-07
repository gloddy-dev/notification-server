package gloddy.notification.port.`in`

import gloddy.notification.dto.ApplyEvent

interface ApplyNotificationCreateUseCase {
    fun create(applyEvent: ApplyEvent)
}