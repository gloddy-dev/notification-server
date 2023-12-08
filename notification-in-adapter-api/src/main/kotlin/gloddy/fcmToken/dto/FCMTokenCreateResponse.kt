package gloddy.fcmToken.dto

import gloddy.fcmToken.FCMToken
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.UserId

data class FCMTokenCreateResponse(
    val userId: UserId,
    val token: FirebaseToken
)

fun FCMToken.toResponse(): FCMTokenCreateResponse =
    FCMTokenCreateResponse(
        userId = this.userId,
        token = this.token
    )