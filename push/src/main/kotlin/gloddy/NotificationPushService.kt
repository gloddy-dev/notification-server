package gloddy

import gloddy.dynamodb.fcmToken.FCMTokenQueryAdapter
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.Notification
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
        val notification = event.notification

        if (isNotPushRequired(notification)) {
            return
        }

        val fcmToken = fcmTokenQueryAdapter.get(notification.userId)
        send(fcmToken.token, notification)
    }

    private fun isNotPushRequired(notification: Notification): Boolean {
        return !notification.type.isNotificationRequired
    }

    private fun send(token: FirebaseToken, notification: Notification) {
        PushCommand(
            token = token.value,
            title = NOTIFICATION_TITLE,
            content = notification.content,
            payload = createPayload(notification.redirectId, notification.type)
        ).run { pushClient.push(this) }
    }

    private fun createPayload(redirectId: Long, type: NotificationType) =
        buildMap {
            put("redirectId", redirectId.toString())
            put("type", type.name)
        }
}