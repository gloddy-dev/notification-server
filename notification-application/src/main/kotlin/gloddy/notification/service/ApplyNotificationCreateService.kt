package gloddy.notification.service

import gloddy.fcmToken.FirebaseToken
import gloddy.notification.*
import gloddy.notification.dto.ApplyEvent
import gloddy.notification.dto.NotificationPushEvent
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.port.`in`.ApplyNotificationCreateUseCase
import gloddy.notification.port.out.FCMTokenGetPort
import gloddy.notification.port.out.NotificationCreatePort
import org.springframework.stereotype.Service

@Service
class ApplyNotificationCreateService(
    private val notificationCreatePort: NotificationCreatePort,
    private val fcmTokenGetPort: FCMTokenGetPort,
    private val notificationEventPublisher: NotificationEventPublisher
): ApplyNotificationCreateUseCase {
    override fun create(applyEvent: ApplyEvent) {
        val fcmToken = fcmTokenGetPort.get(applyEvent.userId)
        val notificationType = NotificationType.of(applyEvent.eventType.name)

        val notification = Notification(
            groupId = applyEvent.groupId,
            userId =  applyEvent.userId,
            content = notificationType.content,
            type = notificationType
        )

        notificationCreatePort.save(notification)
        push(fcmToken.token, notificationType.content, notificationType, applyEvent.groupId)
    }

    private fun push(token: FirebaseToken, content: String, type: NotificationType, groupId: GroupId) {
        if (type.isNotificationRequired) {
            publishPushEvent(token, content, groupId)
        }
    }

    private fun publishPushEvent(token: FirebaseToken, content: String, groupId: GroupId) {
        val event = NotificationPushEvent(
            token = token.value,
            content = content,
            payload = createPayload(groupId)
        )

        notificationEventPublisher.publishPushEvent(event)
    }

    private fun createPayload(groupId: GroupId): Map<String, String> {
        return buildMap {
            put("groupId", groupId.toString())
        }
    }
}