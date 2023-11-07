package gloddy.sqs.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import gloddy.payload.apply.ApplyEvent
import gloddy.payload.group.GroupMemberEvent

class MessageParser {

    companion object{
        private val objectMapper = jacksonObjectMapper()

        fun parseApplyEvent(message: String): ApplyEvent {
            val payload = parsePayloadFromMessage(message)
            return payload.let {
                objectMapper.readValue(it, ApplyEvent::class.java)
            }
        }

        fun parseGroupMemberEvent(message: String): GroupMemberEvent {
            val payload = parsePayloadFromMessage(message)
            return payload.let {
                objectMapper.readValue(it, GroupMemberEvent::class.java)
            }
        }

        private fun parsePayloadFromMessage(message: String): String {
            val outerMessage: Map<String, Any> = objectMapper.readValue(message, Map::class.java) as Map<String, Any>
            return outerMessage["Message"] as String
        }
    }
}