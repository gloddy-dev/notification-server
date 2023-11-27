package gloddy

import gloddy.command.PushCommand
import gloddy.dynamodb.fcmToken.FCMTokenQueryAdapter
import gloddy.fcmToken.FirebaseToken
import org.springframework.stereotype.Component

@Component
class NotificationPushService(
    private val pushClient: PushClient,
    private val fcmTokenQueryAdapter: FCMTokenQueryAdapter
) {

    fun push(pushCommand: PushCommand) {
        val fcmToken = fcmTokenQueryAdapter.get(pushCommand.userId)
        send(fcmToken.token, pushCommand)
    }

    private fun send(fcmToken: FirebaseToken, pushCommand: PushCommand) {
        when (pushCommand.isRequirePush) {
            true -> PushData(
                token = fcmToken.value,
                title = pushCommand.title,
                content = pushCommand.content,
                payload = pushCommand.payload
            ).run { pushClient.push(this) }
            false -> return
        }
    }
}