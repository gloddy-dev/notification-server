package gloddy.fcmToken

import gloddy.fcmToken.dto.FCMTokenCreateRequest
import gloddy.fcmToken.dto.FCMTokenCreateDto
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
        @RequestBody request: FCMTokenCreateRequest,
        @RequestHeader("USER_ID") userId: UserId
    ) {
        fcmTokenCreateUseCase.create(FCMTokenCreateDto(
            userId = userId,
            token = FirebaseToken(request.token)
        ))
    }
}