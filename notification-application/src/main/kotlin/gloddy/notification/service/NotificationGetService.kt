package gloddy.notification.service

import gloddy.notification.Notification
import gloddy.notification.dto.NotificationGetDto
import gloddy.notification.port.`in`.NotificationGetUseCase
import gloddy.notification.port.out.NotificationGetPort
import org.springframework.stereotype.Service

@Service
class NotificationGetService(
    private val notificationGetPort: NotificationGetPort
): NotificationGetUseCase {

    override fun getAllByUser(dto: NotificationGetDto): List<Notification> =
        notificationGetPort.findByUserId(dto.userId)
}