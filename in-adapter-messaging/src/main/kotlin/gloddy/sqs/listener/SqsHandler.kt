package gloddy.sqs.listener

import gloddy.handler.InPayloadHandler
import gloddy.sqs.util.MessageParser
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SqsHandler(
    private val inPayloadHandler: InPayloadHandler
) {

    @SqsListener(value = ["\${sqs.queue.apply}"])
    fun handleApplyEvent(message: String) {
        val applyPayload = MessageParser.parseApplyEvent(message)
        inPayloadHandler.handleApplyPayload(applyPayload)
    }

    @SqsListener(value = ["\${sqs.queue.group-member}"])
    fun handleGroupMemberEvent(message: String) {
        val groupMemberPayload = MessageParser.parseGroupMemberEvent(message)
        inPayloadHandler.handleGroupMemberPayload(groupMemberPayload)
    }
}