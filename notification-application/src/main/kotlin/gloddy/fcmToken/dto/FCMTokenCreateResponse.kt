package gloddy.fcmToken.dto

import gloddy.fcmToken.FCMToken
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.UserId
import gloddy.notification.dto.NotificationDto

data class FCMTokenCreateResponse(
    val userId: UserId,
    val token: FirebaseToken
)

fun FCMToken.toDto(): FCMTokenCreateResponse =
    FCMTokenCreateResponse(
        userId = this.userId,
        token = this.token
    )