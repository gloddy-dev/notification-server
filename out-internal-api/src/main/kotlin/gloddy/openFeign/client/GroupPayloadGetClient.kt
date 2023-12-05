package gloddy.openFeign.client

import gloddy.notification.dto.event.eventType.GroupArticleEventType
import gloddy.notification.dto.event.eventType.GroupEventType
import gloddy.notification.dto.event.eventType.GroupMemberEventType
import gloddy.notification.dto.payload.GroupArticlePayload
import gloddy.notification.dto.payload.GroupMemberPayload
import gloddy.notification.dto.payload.GroupPayload
import gloddy.notification.port.out.GroupPayloadGetPort
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "GroupPayloadGetClient", url = "\${internal.api.base-url}")
interface GroupPayloadGetClient : GroupPayloadGetPort {

    @GetMapping("/groups/{groupId}")
    override fun getGroupPayload(
        @PathVariable("groupId") groupId: Long,
        @RequestParam("eventType") eventType: GroupEventType
    ): GroupPayload

    @GetMapping("/groups/articles/{articleId}")
    override fun getGroupArticlePayload(
        @PathVariable("articleId") articleId: Long,
        @RequestParam("eventType") eventType: GroupArticleEventType
    ): GroupArticlePayload

    @GetMapping("/groups/members/{groupMemberId}")
    override fun getGroupMemberPayload(
        @PathVariable("groupMemberId") groupMemberId: Long,
        @RequestParam("eventType") eventType: GroupMemberEventType
    ): GroupMemberPayload
}