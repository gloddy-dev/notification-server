package gloddy.notification.port.`in`

import gloddy.notification.Notification
import gloddy.notification.dto.NotificationGetDto

interface NotificationGetUseCase {
    fun getAllByUser(dto: NotificationGetDto): List<Notification>
}