package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.dto.event.GroupArticleEvent
import gloddy.notification.dto.event.GroupEvent
import gloddy.notification.dto.event.GroupMemberEvent
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.event.toNotificationCreateEvent
import gloddy.notification.port.`in`.GroupNotificationCreateUseCase
import gloddy.notification.port.out.GroupPayloadGetPort
import gloddy.notification.port.out.NotificationCreatePort
import org.springframework.stereotype.Service

@Service
class GroupNotificationCreateService(
    private val notificationCreatePort: NotificationCreatePort,
    private val notificationEventPublisher: NotificationEventPublisher,
    private val groupPayloadGetPort: GroupPayloadGetPort,
): GroupNotificationCreateUseCase {

    override fun create(event: GroupEvent) {
        val payload = groupPayloadGetPort.getGroupPayload(event.groupId, event.eventType)
        val notificationType = NotificationType.of(event.eventType.name)

        payload.groupMemberIds.value.forEach {
            Notification(
                userId = UserId(it),
                redirectId = RedirectId(payload.groupId),
                title = notificationType.title(null),
                content = notificationType.content,
                type = notificationType
            ).run {
                notificationCreatePort.save(this)
                notificationEventPublisher.publishEvent(this.toNotificationCreateEvent())
            }
        }
    }

    override fun create(event: GroupMemberEvent) {
        val payload = groupPayloadGetPort.getGroupMemberPayload(event.groupMemberId, event.eventType)
        val notificationType = NotificationType.of(event.eventType.name)

        Notification(
            userId = UserId(payload.captainId),
            redirectId = RedirectId(payload.groupId),
            title = notificationType.title(payload.groupMemberName),
            content = notificationType.content,
            type = notificationType
        ).run {
            notificationCreatePort.save(this)
            notificationEventPublisher.publishEvent(this.toNotificationCreateEvent())
        }
    }

    override fun create(event: GroupArticleEvent) {
        val payload = groupPayloadGetPort.getGroupArticlePayload(event.articleId, event.eventType)
        val notificationType = NotificationType.of(event.eventType.name)

        payload.groupMemberIds.value.filter { it != payload.writerId }
            .forEach {
                Notification(
                    userId = UserId(it),
                    redirectId = RedirectId(payload.groupId),
                    title = notificationType.title(null),
                    content = notificationType.content,
                    type = notificationType
                ).run {
                    notificationCreatePort.save(this)
                    notificationEventPublisher.publishEvent(this.toNotificationCreateEvent())
                }
            }
    }
}