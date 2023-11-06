package gloddy.notification.port.out

import gloddy.notification.Notification


interface NotificationCreatePort {
    fun save(notification: Notification)
}