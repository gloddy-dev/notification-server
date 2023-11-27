package gloddy.fcmToken.port.`in`

import gloddy.fcmToken.FCMToken
import gloddy.fcmToken.dto.FCMTokenCreateDto
import gloddy.notification.UserId

interface FCMTokenCreateUseCase {
    fun create(userId: UserId, dto: FCMTokenCreateDto): FCMToken
}