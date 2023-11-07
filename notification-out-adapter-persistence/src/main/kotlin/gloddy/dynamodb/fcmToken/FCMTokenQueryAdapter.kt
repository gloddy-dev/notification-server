package gloddy.dynamodb.fcmToken

import gloddy.fcmToken.FCMToken
import gloddy.notification.UserId
import org.springframework.stereotype.Component

@Component
class FCMTokenQueryAdapter(
    private val fcmTokenRepository: FCMTokenRepository,
) {
    fun get(userId: UserId): FCMToken {
        val entity = fcmTokenRepository.findByUserId(userId.value.toString())
        return entity.toDomain()
    }
}