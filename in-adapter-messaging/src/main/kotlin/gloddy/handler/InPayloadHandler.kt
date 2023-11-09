package gloddy.handler

import gloddy.handler.mapper.toDomainEvent
import gloddy.notification.port.`in`.ApplyNotificationCreateUseCase
import gloddy.notification.port.`in`.GroupNotificationCreateUseCase
import gloddy.payload.apply.ApplyPayload
import gloddy.payload.group.GroupArticlePayload
import gloddy.payload.group.GroupMemberPayload
import gloddy.payload.group.GroupStatusPayload
import org.springframework.stereotype.Component

@Component
class InPayloadHandler(
    private val applyNotificationCreateUseCase: ApplyNotificationCreateUseCase,
    private val groupNotificationCreateUseCase: GroupNotificationCreateUseCase
) {
    fun handleApplyPayload(payload: ApplyPayload) {
        val applyEvent = payload.toDomainEvent()
        applyNotificationCreateUseCase.create(applyEvent)
    }

    fun handleGroupMemberPayload(payload: GroupMemberPayload) {
        val groupEvent = payload.toDomainEvent()
        groupNotificationCreateUseCase.create(groupEvent)
    }

    fun handleGroupArticlePayload(payload: GroupArticlePayload) {
        val groupArticleEvent = payload.toDomainEvent()
        groupNotificationCreateUseCase.create(groupArticleEvent)
    }

    fun handleGroupStatusPayload(payload: GroupStatusPayload) {
        val groupStatusEvent = payload.toDomainEvent()
        groupNotificationCreateUseCase.create(groupStatusEvent)
    }
}