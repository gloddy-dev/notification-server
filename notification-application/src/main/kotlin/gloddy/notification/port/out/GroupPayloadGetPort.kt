package gloddy.notification.port.out

import gloddy.notification.dto.event.eventType.GroupArticleEventType
import gloddy.notification.dto.event.eventType.GroupEventType
import gloddy.notification.dto.event.eventType.GroupMemberEventType
import gloddy.notification.dto.payload.GroupArticlePayload
import gloddy.notification.dto.payload.GroupMemberPayload
import gloddy.notification.dto.payload.GroupPayload

interface GroupPayloadGetPort {
    fun getGroupPayload(groupId: Long, eventType: GroupEventType): GroupPayload
    fun getGroupArticlePayload(articleId: Long, eventType: GroupArticleEventType): GroupArticlePayload
    fun getGroupMemberPayload(groupMemberId: Long, eventType: GroupMemberEventType): GroupMemberPayload
}