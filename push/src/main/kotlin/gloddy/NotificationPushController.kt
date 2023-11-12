package gloddy

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notifications")
class NotificationPushController(
    private val pushClient: PushClient

) {

    @PostMapping("/push")
    fun pushTest(
        @RequestHeader("TOKEN") token: String
    ): String? {
        return try {
            pushClient.push(PushCommand(
                token = token,
                title = "TEST",
                content = "알림 전송 성공!",
                payload = buildMap { put("redirectId", "1") }
            ))
            "Success push notification"
        } catch (e: Exception) {
            e.message
        }
    }
}
