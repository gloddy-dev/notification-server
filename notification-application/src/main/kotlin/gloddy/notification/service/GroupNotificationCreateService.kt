package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.dto.GroupEvent
import gloddy.notification.event.NotificationPushEvent
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.port.`in`.GroupNotificationCreateUseCase
import gloddy.notification.port.out.NotificationCreatePort
import org.springframework.stereotype.Service

@Service
class GroupNotificationCreateService(
    private val notificationCreatePort: NotificationCreatePort,
    private val notificationEventPublisher: NotificationEventPublisher,
//    private val groupPayloadGetPort: GroupPayloadGetPort,
): GroupNotificationCreateUseCase {

    override fun create(groupEvent: GroupEvent) {
//        val payload = groupPayloadGetPort.get(groupEvent.userId)

        val notificationType = NotificationType.of(groupEvent.eventType.name)
        val content = notificationType.getContent("TEST")

        val notification = Notification(
            redirectId = groupEvent.groupId,
            userId =  groupEvent.userId,
            content = content,
            type = notificationType
        )

        notificationCreatePort.save(notification)
        publishPushEvent(groupEvent.userId, content, groupEvent.groupId, notificationType)
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