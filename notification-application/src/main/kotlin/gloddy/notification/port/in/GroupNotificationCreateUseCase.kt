package gloddy.notification.port.`in`

import gloddy.notification.dto.event.GroupArticleEvent
import gloddy.notification.dto.event.GroupEvent
import gloddy.notification.dto.event.GroupMemberEvent

interface GroupNotificationCreateUseCase {
    fun create(event: GroupEvent)
    fun create(event: GroupMemberEvent)
    fun create(event: GroupArticleEvent)
}