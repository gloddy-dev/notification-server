package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.NotificationType.APPLY_CREATE
import gloddy.notification.dto.event.ApplyEvent
import gloddy.notification.dto.payload.ApplyPayload
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.event.toNotificationCreateEvent
import gloddy.notification.port.`in`.ApplyNotificationCreateUseCase
import gloddy.notification.port.out.ApplyPayloadGetPort
import gloddy.notification.port.out.NotificationCreatePort
import org.springframework.stereotype.Service

@Service
class ApplyNotificationCreateService(
    private val notificationCreatePort: NotificationCreatePort,
    private val applyPayloadGetPort: ApplyPayloadGetPort,
    private val notificationEventPublisher: NotificationEventPublisher,
): ApplyNotificationCreateUseCase {

    override fun create(event: ApplyEvent) {
        val payload = applyPayloadGetPort.getApplyPayload(event.applyId, event.eventType)
        val notificationType = NotificationType.of(event.eventType.name)

        Notification(
            userId =  getTargetUserId(notificationType, payload),
            redirectId = RedirectId(payload.groupId),
            title = notificationType.title(null),
            content = notificationType.content,
            type = notificationType,
            image = payload.groupImage
        ).run {
            notificationCreatePort.save(this)
            notificationEventPublisher.publishEvent(this.toNotificationCreateEvent())
        }
    }

    private fun getTargetUserId(type: NotificationType, payload: ApplyPayload): UserId {
        return when(type) {
            in listOf(APPLY_CREATE) -> payload.captainId
            else -> payload.applyUserId
        }.run { UserId(this) }
    }
}