package gloddy.fcmToken.service

import gloddy.fcmToken.dto.FCMTokenCreateDto
import gloddy.fcmToken.port.`in`.FCMTokenCreateUseCase
import gloddy.fcmToken.port.out.FCMTokenCreatePort
import gloddy.fcmToken.FCMToken
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.UserId
import org.springframework.stereotype.Service

@Service
class FCMTokenCreateService(
    private val fcmTokenCreatePort: FCMTokenCreatePort
): FCMTokenCreateUseCase {

    override fun create(userId: UserId, dto: FCMTokenCreateDto): FCMToken {
        val fcmToken = FCMToken(
            userId = userId,
            token = FirebaseToken(dto.token)
        )
        return fcmTokenCreatePort.create(fcmToken)
    }
}