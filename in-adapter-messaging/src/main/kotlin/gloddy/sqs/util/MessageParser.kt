package gloddy.sqs.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import gloddy.payload.apply.ApplyPayload
import gloddy.payload.group.GroupArticlePayload
import gloddy.payload.group.GroupMemberPayload
import gloddy.payload.group.GroupStatusPayload

class MessageParser {

    companion object{
        private val objectMapper = jacksonObjectMapper()

        fun parseApplyEvent(message: String): ApplyPayload {
            val payload = parsePayloadFromMessage(message)
            return objectMapper.readValue(payload, ApplyPayload::class.java)
        }

        fun parseGroupMemberEvent(message: String): GroupMemberPayload {
            val payload = parsePayloadFromMessage(message)
            return objectMapper.readValue(payload, GroupMemberPayload::class.java)
        }

        fun parseGroupArticleEvent(message: String): GroupArticlePayload {
            val payload = parsePayloadFromMessage(message);
            return objectMapper.readValue(payload, GroupArticlePayload::class.java)
        }

        fun parseGroupStatusEvent(message: String): GroupStatusPayload {
            val payload = parsePayloadFromMessage(message);
            return objectMapper.readValue(payload, GroupStatusPayload::class.java)
        }

        private fun parsePayloadFromMessage(message: String): String {
            val outerMessage: Map<String, Any> = objectMapper.readValue(message, Map::class.java) as Map<String, Any>
            return outerMessage["Message"] as String
        }
    }
}