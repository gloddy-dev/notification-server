package gloddy.dynamodb.fcmToken

import gloddy.fcmToken.port.out.FCMTokenCreatePort
import gloddy.fcmToken.FCMToken
import org.springframework.stereotype.Component

@Component
class FCMTokenCommandAdapter(
    private val fcmTokenRepository: FCMTokenRepository
): FCMTokenCreatePort {
    override fun create(fcmToken: FCMToken): FCMToken {
        val entity = fcmTokenRepository.save(fcmToken.toEntity())
        return entity.toDomain()
    }
}