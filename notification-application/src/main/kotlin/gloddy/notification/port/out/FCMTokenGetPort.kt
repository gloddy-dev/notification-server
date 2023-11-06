package gloddy.notification.port.out

import gloddy.fcmToken.FCMToken
import gloddy.notification.UserId

interface FCMTokenGetPort {
    fun get(userId: UserId): FCMToken
}