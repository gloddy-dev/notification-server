package gloddy.event

import gloddy.NotificationPushService
import gloddy.command.toGroupingPushCommand
import gloddy.notification.event.NotificationCreateEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class NotificationEventListener(
    private val notificationPushService: NotificationPushService
) {

    @EventListener
    fun consume(event: NotificationCreateEvent) {
        notificationPushService.push(event.toGroupingPushCommand())
    }
}