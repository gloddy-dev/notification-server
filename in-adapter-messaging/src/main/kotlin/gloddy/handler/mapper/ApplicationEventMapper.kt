package gloddy.handler.mapper

import gloddy.notification.ApplyEventType
import gloddy.notification.GroupEventType
import gloddy.notification.UserId
import gloddy.notification.dto.*
import gloddy.payload.apply.ApplyPayload
import gloddy.payload.apply.ApplyPayloadType
import gloddy.payload.group.*

fun GroupArticlePayload.toDomainEvent(): GroupArticleEvent =
    GroupArticleEvent(
        userId = UserId(this.userId),
        groupId = this.groupId,
        groupMemberUserIds = this.groupMemberUserIds.map { UserId(it) },
        articleId = this.articleId,
        eventType = this.eventType.toDomainEventType()
    )

fun GroupStatusPayload.toDomainEvent(): GroupStatusEvent =
    GroupStatusEvent(
        groupId = this.groupId,
        groupMemberUserIds = this.groupMemberUserIds.map { UserId(it) },
        eventType = this.eventType.toDomainEventType()
    )

fun ApplyPayload.toDomainEvent(): ApplyEvent =
    ApplyEvent(
        userId = UserId(this.userId),
        applyGroupId = this.applyGroupId,
        applyUserId = UserId(this.applyUserId),
        eventType = this.eventType.toDomainEventType()
    )

fun GroupMemberPayload.toDomainEvent(): GroupEvent =
    GroupEvent(
        userId = UserId(this.userId),
        groupId = this.groupId,
        eventType = this.eventType.toDomainEventType()
    )
private fun GroupArticlePayloadType.toDomainEventType(): GroupArticleEventType =
    when(this) {
        GroupArticlePayloadType.CREATE_GENERAL_ARTICLE -> GroupArticleEventType.GROUP_ARTICLE_CREATE
        GroupArticlePayloadType.CREATE_NOTICE_ARTICLE -> GroupArticleEventType.GROUP_ARTICLE_CREATE
    }

private fun GroupStatusPayloadType.toDomainEventType(): GroupStatusEventType =
    when(this) {
        GroupStatusPayloadType.APPROACHING_GROUP -> GroupStatusEventType.GROUP_APPROACHING_START
        GroupStatusPayloadType.END_GROUP -> GroupStatusEventType.GROUP_END
    }

private fun ApplyPayloadType.toDomainEventType(): ApplyEventType =
    when(this) {
        ApplyPayloadType.APPLY_CREATE -> ApplyEventType.APPLY_CREATE
        ApplyPayloadType.APPLY_APPROVE -> ApplyEventType.APPLY_APPROVE
        ApplyPayloadType.APPLY_REFUSE -> ApplyEventType.APPLY_REFUSE
    }

private fun GroupMemberPayloadType.toDomainEventType(): GroupEventType =
    when(this) {
        GroupMemberPayloadType.GROUP_MEMBER_LEAVE -> GroupEventType.GROUP_LEAVE
    }
