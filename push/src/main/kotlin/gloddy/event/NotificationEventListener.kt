package gloddy.event

import gloddy.NotificationPushService
import gloddy.notification.dto.NotificationPushEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class NotificationEventListener(
    private val notificationPushService: NotificationPushService
) {

    @EventListener
    fun consume(event: NotificationPushEvent) {
        notificationPushService.push(event)
    }
}