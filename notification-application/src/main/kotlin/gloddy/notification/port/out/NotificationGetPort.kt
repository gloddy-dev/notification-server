package gloddy.notification.port.out

import gloddy.notification.Notification
import gloddy.notification.UserId

interface NotificationGetPort {
    fun findByUserId(userId: UserId): List<Notification>
}