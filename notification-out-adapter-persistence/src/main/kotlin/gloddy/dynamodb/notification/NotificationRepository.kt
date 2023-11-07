package gloddy.dynamodb.notification

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface NotificationRepository : CrudRepository<NotificationEntity, String> {
    fun findByUserId(userId: String): List<NotificationEntity>
}