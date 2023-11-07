package gloddy.fcmToken.port.out

import gloddy.fcmToken.FCMToken

interface FCMTokenCreatePort {
    fun create(fcmToken: FCMToken): FCMToken
}