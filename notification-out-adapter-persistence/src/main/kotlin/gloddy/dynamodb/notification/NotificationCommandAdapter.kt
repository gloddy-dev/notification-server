package gloddy.dynamodb.notification

import gloddy.notification.Notification
import gloddy.notification.port.out.NotificationCreatePort
import org.springframework.stereotype.Component

@Component
class NotificationCommandAdapter(
    private val notificationRepository: NotificationRepository,
    private val notificationMapper: NotificationMapper
): NotificationCreatePort {
    override fun save(notification: Notification) {
        notificationRepository.save(notificationMapper.toEntity(notification))
    }
}