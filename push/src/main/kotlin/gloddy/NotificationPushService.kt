package gloddy

import gloddy.notification.dto.NotificationPushEvent
import org.springframework.stereotype.Component

@Component
class NotificationPushService(
    private val pushClient: PushClient
) {
    companion object {
        const val NOTIFICATION_TITLE = "Gloddy"
    }

    fun push(event: NotificationPushEvent) {
        pushClient.push(
            PushCommand(
                token = event.token,
                title = NOTIFICATION_TITLE,
                content = event.content,
                payload = event.payload
            )
        )
    }
}