package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.dto.GroupEvent
import gloddy.notification.event.NotificationPushEvent
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.port.`in`.GroupNotificationCreateUseCase
import gloddy.notification.port.out.FCMTokenGetPort
import gloddy.notification.port.out.NotificationCreatePort
import gloddy.fcmToken.FirebaseToken
import org.springframework.stereotype.Service

@Service
class GroupNotificationCreateService(
    private val notificationCreatePort: NotificationCreatePort,
    private val notificationEventPublisher: NotificationEventPublisher,
//    private val groupPayloadGetPort: GroupPayloadGetPort,
    private val FCMTokenGetPort: FCMTokenGetPort
): GroupNotificationCreateUseCase {
    override fun create(groupEvent: GroupEvent) {
//        val payload = groupPayloadGetPort.get(groupEvent.userId)
        val fcmToken = FCMTokenGetPort.get(groupEvent.userId)

        val notificationType = NotificationType.of(groupEvent.eventType.name)
        val content = notificationType.getContent("TEST")

        val notification = Notification(
            groupId = groupEvent.groupId,
            userId =  groupEvent.userId,
            content = content,
            type = notificationType
        )

        notificationCreatePort.save(notification)
        push(fcmToken.token, content, notificationType, groupEvent.groupId)
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