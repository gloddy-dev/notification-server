package gloddy.openFeign.client

import gloddy.notification.dto.event.eventType.ApplyEventType
import gloddy.notification.dto.payload.ApplyPayload
import gloddy.notification.port.out.ApplyPayloadGetPort
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "ApplyPayloadGetClient", url = "\${internal.api.base-url}")
interface ApplyPayloadGetClient : ApplyPayloadGetPort {

    @GetMapping("/applies/{applyId}")
    override fun getApplyPayload(
        @PathVariable("applyId") applyId: Long,
        @RequestParam("eventType") eventType: ApplyEventType
    ): ApplyPayload
}