package gloddy.dynamodb.fcmToken

import gloddy.fcmToken.port.out.FCMTokenCreatePort
import gloddy.fcmToken.FCMToken
import org.springframework.stereotype.Component

@Component
class FCMTokenCommandAdapter(
    private val fcmTokenRepository: FCMTokenRepository,
    private val fcmTokenMapper: FCMTokenMapper
): FCMTokenCreatePort {
    override fun create(fcmToken: FCMToken) {
        val entity = fcmTokenMapper.toEntity(fcmToken)
        fcmTokenRepository.save(entity)
    }
}