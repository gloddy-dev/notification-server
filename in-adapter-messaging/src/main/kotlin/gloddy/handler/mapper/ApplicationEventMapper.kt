package gloddy.handler.mapper

import gloddy.notification.UserId
import gloddy.notification.dto.event.eventType.ApplyEventType
import gloddy.notification.dto.event.eventType.GroupMemberEventType
import gloddy.notification.dto.event.ApplyEvent
import gloddy.notification.dto.event.GroupArticleEvent
import gloddy.notification.dto.event.GroupEvent
import gloddy.notification.dto.event.GroupMemberEvent
import gloddy.notification.dto.event.eventType.GroupArticleEventType
import gloddy.notification.dto.event.eventType.GroupEventType
import gloddy.payload.apply.ApplyPayload
import gloddy.payload.apply.ApplyPayloadType
import gloddy.payload.group.*

fun GroupArticlePayload.toDomainEvent(): GroupArticleEvent =
    GroupArticleEvent(
        articleId = this.articleId,
        eventType = this.eventType.toDomainEventType(),
        eventDateTime = this.eventDateTime
    )

fun GroupMemberPayload.toDomainEvent(): GroupMemberEvent =
    GroupMemberEvent(
        userId = UserId(this.userId),
        groupId = this.groupId,
        eventType = this.eventType.toDomainEventType(),
        eventDateTime = this.eventDateTime
    )

fun ApplyPayload.toDomainEvent(): ApplyEvent =
    ApplyEvent(
        applyId = this.applyId,
        eventType = this.eventType.toDomainEventType(),
        eventDateTime = this.eventDateTime
    )

fun GroupPayload.toDomainEvent(): GroupEvent =
    GroupEvent(
        groupId = this.groupId,
        eventType = this.eventType.toDomainEventType(),
        eventDateTime = this.eventDateTime
    )
private fun GroupArticlePayloadType.toDomainEventType(): GroupArticleEventType =
    when(this) {
        GroupArticlePayloadType.CREATE_GENERAL_ARTICLE -> GroupArticleEventType.GROUP_ARTICLE_CREATE
        GroupArticlePayloadType.CREATE_NOTICE_ARTICLE -> GroupArticleEventType.GROUP_ARTICLE_CREATE
    }

private fun GroupPayloadType.toDomainEventType(): GroupEventType =
    when(this) {
        GroupPayloadType.APPROACHING_GROUP -> GroupEventType.GROUP_APPROACHING_START
        GroupPayloadType.END_GROUP -> GroupEventType.GROUP_END
    }

private fun ApplyPayloadType.toDomainEventType(): ApplyEventType =
    when(this) {
        ApplyPayloadType.APPLY_CREATE -> ApplyEventType.APPLY_CREATE
        ApplyPayloadType.APPLY_APPROVE -> ApplyEventType.APPLY_APPROVE
        ApplyPayloadType.APPLY_REFUSE -> ApplyEventType.APPLY_REFUSE
    }

private fun GroupMemberPayloadType.toDomainEventType(): GroupMemberEventType =
    when(this) {
        GroupMemberPayloadType.GROUP_MEMBER_LEAVE -> GroupMemberEventType.GROUP_LEAVE
    }
