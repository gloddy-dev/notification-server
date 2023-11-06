package gloddy.fcmToken.service

import gloddy.fcmToken.dto.FCMTokenCreateDto
import gloddy.fcmToken.port.`in`.FCMTokenCreateUseCase
import gloddy.fcmToken.port.out.FCMTokenCreatePort
import gloddy.fcmToken.FCMToken
import org.springframework.stereotype.Service

@Service
class FCMTokenCreateService(
    private val fcmTokenCreatePort: FCMTokenCreatePort
): FCMTokenCreateUseCase {
    override fun create(dto: FCMTokenCreateDto) {
        val fcmToken = FCMToken(
            userId = dto.userId,
            token = dto.token
        )
        fcmTokenCreatePort.create(fcmToken)
    }
}