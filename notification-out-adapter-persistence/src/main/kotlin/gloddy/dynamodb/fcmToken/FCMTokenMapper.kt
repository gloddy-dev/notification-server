package gloddy.dynamodb.fcmToken

import gloddy.fcmToken.FCMToken
import gloddy.fcmToken.FirebaseToken
import gloddy.notification.UserId
import org.springframework.stereotype.Component

@Component
class FCMTokenMapper {

    fun toDomain(entity: FCMTokenEntity): FCMToken {
        return FCMToken(
            userId = UserId(entity.userId.toLong()),
            token = FirebaseToken(entity.token)
        )
    }

    fun toEntity(domain: FCMToken): FCMTokenEntity {
        return FCMTokenEntity(
            userId = domain.userId.value.toString(),
            token = domain.token.value
        )
    }
}