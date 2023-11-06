package gloddy.dynamodb.fcmToken

import gloddy.fcmToken.FCMToken
import gloddy.notification.UserId
import gloddy.notification.port.out.FCMTokenGetPort
import org.springframework.stereotype.Component

@Component
class FCMTokenQueryAdapter(
    private val fcmTokenRepository: FCMTokenRepository,
    private val fcmTokenMapper: FCMTokenMapper
): FCMTokenGetPort {
    override fun get(userId: UserId): FCMToken {
        val entity = fcmTokenRepository.findByUserId(userId.value.toString())
        return fcmTokenMapper.toDomain(entity)
    }
}