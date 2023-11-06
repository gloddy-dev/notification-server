package gloddy.notification.port.`in`

import gloddy.notification.dto.GroupEvent

interface GroupNotificationCreateUseCase {
    fun create(groupEvent: GroupEvent)
}