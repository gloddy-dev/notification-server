package gloddy

import gloddy.dynamodb.fcmToken.FCMTokenQueryAdapter
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.NotificationType
import gloddy.notification.event.NotificationPushEvent
import org.springframework.stereotype.Component

@Component
class NotificationPushService(
    private val pushClient: PushClient,
    private val fcmTokenQueryAdapter: FCMTokenQueryAdapter
) {
    companion object {
        const val NOTIFICATION_TITLE = "Gloddy"
    }

    fun push(event: NotificationPushEvent) {
        if (!event.type.isNotificationRequired) {
            return
        }

        val fcmToken = fcmTokenQueryAdapter.get(event.userId)
        send(fcmToken.token, event)
    }

    fun send(token: FirebaseToken, event: NotificationPushEvent) {
        PushCommand(
            token = token.value,
            title = NOTIFICATION_TITLE,
            content = event.content,
            payload = createPayload(event.redirectId, event.type)
        ).run { pushClient.push(this) }
    }

    private fun createPayload(redirectId: Long, type: NotificationType) =
        buildMap {
            put("redirectId", redirectId.toString())
            put("type", type.name)
        }
}