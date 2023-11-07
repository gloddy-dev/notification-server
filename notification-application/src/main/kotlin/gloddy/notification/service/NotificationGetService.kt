package gloddy.notification.service

import gloddy.notification.dto.NotificationGetDto
import gloddy.notification.dto.NotificationResponse
import gloddy.notification.dto.toResponse
import gloddy.notification.port.`in`.NotificationGetUseCase
import gloddy.notification.port.out.NotificationGetPort
import org.springframework.stereotype.Service

@Service
class NotificationGetService(
    private val notificationGetPort: NotificationGetPort
): NotificationGetUseCase {

    override fun getAllByUser(dto: NotificationGetDto): NotificationResponse =
        notificationGetPort.findByUserId(dto.userId).toResponse()

}