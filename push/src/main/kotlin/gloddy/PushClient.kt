package gloddy

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.stereotype.Component

@Component
class PushClient {

    fun push(data: PushData) {
        val message = Message.builder()
            .putData("title", data.title)
            .putData("content", data.content)
            .setNotification(
                Notification.builder()
                    .setTitle(data.title)
                    .setBody(data.content)
                    .build()
            )
            .putAllData(data.payload)
            .setToken(data.token)
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