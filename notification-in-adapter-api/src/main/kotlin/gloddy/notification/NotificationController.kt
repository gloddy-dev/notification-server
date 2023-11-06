package gloddy.notification

import gloddy.notification.dto.NotificationGetDto
import gloddy.notification.port.`in`.NotificationGetUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notifications")
class NotificationController(
    private val notificationGetUseCase: NotificationGetUseCase
) {

    @GetMapping
    fun getAllByUser(@RequestHeader("USER_ID") userId: UserId) =
        notificationGetUseCase.getAllByUser(NotificationGetDto(userId))
}