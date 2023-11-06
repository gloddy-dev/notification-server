package gloddy.fcmToken

import gloddy.notification.UserId

@JvmInline
value class FirebaseToken(val value: String)
data class FCMToken(
    val userId: UserId,
    val token: FirebaseToken
)