package gloddy.notification.port.`in`

import gloddy.notification.dto.NotificationGetDto
import gloddy.notification.dto.NotificationResponse

interface NotificationGetUseCase {
    fun getAllByUser(dto: NotificationGetDto): NotificationResponse
}