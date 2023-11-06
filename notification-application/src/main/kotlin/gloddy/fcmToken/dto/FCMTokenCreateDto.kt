package gloddy.fcmToken.dto

import gloddy.fcmToken.FirebaseToken
import gloddy.notification.UserId

data class FCMTokenCreateDto(
    val userId: UserId,
    val token: FirebaseToken
)