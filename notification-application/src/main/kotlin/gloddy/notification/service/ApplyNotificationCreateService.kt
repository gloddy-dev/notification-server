package gloddy.notification.service

import gloddy.notification.*
import gloddy.notification.NotificationType.APPLY_CREATE
import gloddy.notification.dto.ApplyEvent
import gloddy.notification.event.NotificationEventPublisher
import gloddy.notification.event.toNotificationCreateEvent
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

        Notification(
            redirectId = applyEvent.applyGroupId,
            userId =  getTargetUserId(type, applyEvent),
            content = type.content,
            type = type
        ).run {
            notificationCreatePort.save(this)
            notificationEventPublisher.publishEvent(this.toNotificationCreateEvent())
        }
    }

    private fun getTargetUserId(type: NotificationType, applyEvent: ApplyEvent): UserId {
        return when(type) {
            in listOf(APPLY_CREATE) -> applyEvent.userId
            else -> applyEvent.applyUserId
        }
    }
}