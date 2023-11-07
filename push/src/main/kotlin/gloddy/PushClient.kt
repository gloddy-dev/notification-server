package gloddy

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import org.springframework.stereotype.Component

@Component
class PushClient {

    fun push(command: PushCommand) {
        val message = Message.builder()
            .putData("title", command.title)
            .putData("content", command.content)
            .putAllData(command.payload)
            .setToken(command.token)
            .build()

        runCatching {
            FirebaseMessaging.getInstance().send(message)
        }.onSuccess {
            print("Success push notification")
        }.onFailure {
            print("Failed to push notification")
        }.getOrThrow()
    }
}