package gloddy.handler

import gloddy.handler.mapper.ApplicationEventMapper
import gloddy.notification.port.`in`.ApplyNotificationCreateUseCase
import gloddy.notification.port.`in`.GroupNotificationCreateUseCase
import gloddy.payload.apply.ApplyPayload
import gloddy.payload.group.GroupMemberPayload
import org.springframework.stereotype.Component

@Component
class InPayloadHandler(
    private val applyNotificationCreateUseCase: ApplyNotificationCreateUseCase,
    private val groupNotificationCreateUseCase: GroupNotificationCreateUseCase
) {
    fun handleApplyPayload(payload: ApplyPayload) {
        val applyEvent = ApplicationEventMapper.mapToApplyEvent(payload)
        applyNotificationCreateUseCase.create(applyEvent)
    }

    fun handleGroupMemberPayload(payload: GroupMemberPayload) {
        val groupEvent = ApplicationEventMapper.mapToGroupEvent(payload)
        groupNotificationCreateUseCase.create(groupEvent)
    }
}