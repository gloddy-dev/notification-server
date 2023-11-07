package gloddy.dynamodb.notification

import gloddy.notification.Notification
import gloddy.notification.UserId
import gloddy.notification.port.out.NotificationGetPort
import org.springframework.stereotype.Component

@Component
class NotificationQueryAdapter(
    private val notificationRepository: NotificationRepository,
): NotificationGetPort {

    override fun findByUserId(userId: UserId): List<Notification> {
        val entities = notificationRepository.findByUserId(userId.value.toString())
        return entities.map { it.toDomain() }.toList()
    }
}