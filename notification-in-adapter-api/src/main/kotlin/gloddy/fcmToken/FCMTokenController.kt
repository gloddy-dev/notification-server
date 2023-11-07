package gloddy.fcmToken

import gloddy.fcmToken.dto.FCMTokenCreateDto
import gloddy.fcmToken.dto.FCMTokenCreateResponse
import gloddy.fcmToken.port.`in`.FCMTokenCreateUseCase
import gloddy.notification.UserId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/notifications")
class FCMTokenController(
    private val fcmTokenCreateUseCase: FCMTokenCreateUseCase
) {
    @PostMapping("/tokens")
    fun create(
        @RequestBody request: FCMTokenCreateDto,
        @RequestHeader("USER_ID") userId: UserId
    ): FCMTokenCreateResponse {
        return fcmTokenCreateUseCase.create(userId, request)
    }
}