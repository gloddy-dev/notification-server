package gloddy.fcmToken.port.`in`

import gloddy.fcmToken.dto.FCMTokenCreateDto

interface FCMTokenCreateUseCase {
    fun create(dto: FCMTokenCreateDto)
}