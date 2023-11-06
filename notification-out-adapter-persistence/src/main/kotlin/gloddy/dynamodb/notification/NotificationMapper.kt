package gloddy.dynamodb.notification

import gloddy.notification.GroupId
import gloddy.notification.Notification
import gloddy.notification.UserId
import org.springframework.stereotype.Component

@Component
class NotificationMapper {

    fun toDomain(entity: NotificationEntity): Notification {
        return Notification(
            userId = UserId(entity.userId.toLong()),
            groupId = GroupId(entity.groupId.toLong()),
            content = entity.content,
            type = entity.type!!
        )
    }

    fun toEntity(domain: Notification): NotificationEntity {
        return NotificationEntity(
            userId = domain.userId.value.toString(),
            groupId = domain.groupId.value.toString(),
            content = domain.content,
            type = domain.type
        )
    }
}