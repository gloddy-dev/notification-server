package gloddy.notification.event

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class NotificationEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun publishPushEvent(event: NotificationPushEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}