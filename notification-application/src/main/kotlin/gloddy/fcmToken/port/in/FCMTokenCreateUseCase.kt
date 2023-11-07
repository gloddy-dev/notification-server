package gloddy.fcmToken.port.`in`

import gloddy.fcmToken.dto.FCMTokenCreateDto
import gloddy.fcmToken.dto.FCMTokenCreateResponse
import gloddy.notification.UserId

interface FCMTokenCreateUseCase {
    fun create(userId: UserId, dto: FCMTokenCreateDto): FCMTokenCreateResponse
}