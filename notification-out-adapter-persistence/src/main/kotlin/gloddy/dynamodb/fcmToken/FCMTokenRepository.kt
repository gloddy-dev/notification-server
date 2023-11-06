package gloddy.dynamodb.fcmToken

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface FCMTokenRepository : CrudRepository<FCMTokenEntity, String> {
    fun findByUserId(userId: String): FCMTokenEntity
}