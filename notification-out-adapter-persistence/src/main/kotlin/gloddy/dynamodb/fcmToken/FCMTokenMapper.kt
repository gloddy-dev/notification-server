package gloddy.dynamodb.fcmToken

import gloddy.fcmToken.FCMToken
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.UserId


fun FCMTokenEntity.toDomain(): FCMToken =
    FCMToken(
        userId = UserId(this.userId.toLong()),
        token = FirebaseToken(this.token)
    )

fun FCMToken.toEntity(): FCMTokenEntity =
    FCMTokenEntity(
        userId = this.userId.value.toString(),
        token = this.token.value
    )
