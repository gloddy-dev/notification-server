package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.dto.ApplyEvent
import gloddy.notification.event.NotificationPushEvent
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.port.`in`.ApplyNotificationCreateUseCase
import gloddy.notification.port.out.NotificationCreatePort
import org.springframework.stereotype.Service

@Service
class ApplyNotificationCreateService(
    private val notificationCreatePort: NotificationCreatePort,
    private val notificationEventPublisher: NotificationEventPublisher
): ApplyNotificationCreateUseCase {

    override fun create(applyEvent: ApplyEvent) {
        val type = NotificationType.of(applyEvent.eventType.name)

        val notification = Notification(
            redirectId = applyEvent.groupId,
            userId =  applyEvent.userId,
            content = type.content,
            type = type
        )

        notificationCreatePort.save(notification)
        publishPushEvent(applyEvent.userId, type.content, applyEvent.groupId, type)
    }

    private fun publishPushEvent(userId: UserId, content: String, redirectId: Long, type: NotificationType) {
        val event = NotificationPushEvent(
            userId = userId,
            content = content,
            redirectId = redirectId,
            type = type
        )

        notificationEventPublisher.publishPushEvent(event)
    }
}