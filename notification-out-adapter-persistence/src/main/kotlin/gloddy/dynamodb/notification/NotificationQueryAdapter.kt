package gloddy.dynamodb.notification

import gloddy.notification.Notification
import gloddy.notification.UserId
import gloddy.notification.port.out.NotificationGetPort
import org.springframework.stereotype.Component

@Component
class NotificationQueryAdapter(
    private val notificationRepository: NotificationRepository,
    private val notificationMapper: NotificationMapper
): NotificationGetPort {

    override fun findByUserId(userId: UserId): List<Notification> {
        return notificationRepository.findByUserId(userId.value.toString())
            .map{notificationMapper.toDomain(it)}
            .toList()
    }
}