package gloddy.notification.port.`in`

import gloddy.notification.dto.GroupArticleEvent
import gloddy.notification.dto.GroupEvent
import gloddy.notification.dto.GroupStatusEvent

interface GroupNotificationCreateUseCase {
    fun create(groupEvent: GroupEvent)
    fun create(groupStatusEvent: GroupStatusEvent)
    fun create(groupArticleEvent: GroupArticleEvent)
}