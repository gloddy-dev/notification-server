package gloddy.handler.mapper

import gloddy.notification.ApplyEventType
import gloddy.notification.GroupEventType
import gloddy.notification.UserId
import gloddy.notification.dto.ApplyEvent
import gloddy.notification.dto.GroupEvent
import gloddy.payload.apply.ApplyPayload
import gloddy.payload.apply.ApplyPayloadType
import gloddy.payload.group.GroupMemberPayload
import gloddy.payload.group.GroupMemberPayloadType

class ApplicationEventMapper {

    companion object {
        fun mapToApplyEvent(payload: ApplyPayload): ApplyEvent {
            return ApplyEvent(
                userId = UserId(payload.userId),
                groupId = payload.groupId,
                mapToApplyEventType(payload.eventType)
            )
        }

        fun mapToGroupEvent(payload: GroupMemberPayload): GroupEvent {
            return GroupEvent(
                userId = UserId(payload.userId),
                groupId = payload.groupId,
                eventType = mapToGroupEventType(payload.eventType)
            )
        }

        private fun mapToGroupEventType(payloadType: GroupMemberPayloadType): GroupEventType {
            return when(payloadType) {
                GroupMemberPayloadType.GROUP_MEMBER_LEAVE -> GroupEventType.GROUP_LEAVE
            }
        }

        private fun mapToApplyEventType(payloadType: ApplyPayloadType): ApplyEventType {
            return when(payloadType) {
                ApplyPayloadType.APPLY_CREATE -> ApplyEventType.APPLY_CREATE
                ApplyPayloadType.APPLY_APPROVE -> ApplyEventType.APPLY_APPROVE
                ApplyPayloadType.APPLY_REFUSE -> ApplyEventType.APPLY_REFUSE
            }
        }
    }
}