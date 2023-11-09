package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.dto.GroupArticleEvent
import gloddy.notification.dto.GroupEvent
import gloddy.notification.dto.GroupStatusEvent
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

        Notification(
            redirectId = groupEvent.groupId,
            userId =  groupEvent.userId,
            content = notificationType.content,
            type = notificationType
        ).run { notificationCreatePort.save(this) }

        publishPushEvent(groupEvent.userId, notificationType.content, groupEvent.groupId, notificationType)
    }

    override fun create(event: GroupStatusEvent) {
        val notificationType = NotificationType.of(event.eventType.name)

        event.groupMemberUserIds
            .map { Notification(
                userId = it,
                redirectId = event.groupId,
                content = notificationType.content,
                type = notificationType
            ) }
            .forEach { notificationCreatePort.save(it) }

        event.groupMemberUserIds
            .forEach{ publishPushEvent(it, notificationType.content, event.groupId, notificationType) }
    }

    override fun create(event: GroupArticleEvent) {
        val notificationType = NotificationType.of(event.eventType.name)

        event.groupMemberUserIds
            .map { Notification(
                userId = it,
                redirectId = event.groupId,
                content = notificationType.content,
                type = notificationType
            ) }
            .forEach { notificationCreatePort.save(it) }

        event.groupMemberUserIds
            .forEach{ publishPushEvent(it, notificationType.content, event.groupId, notificationType) }
    }

    private fun publishPushEvent(userId: UserId, content: String, redirectId: Long, type: NotificationType) {
        NotificationPushEvent(
            userId = userId,
            content = content,
            redirectId = redirectId,
            type = type
        ).run { notificationEventPublisher.publishPushEvent(this) }
    }
}