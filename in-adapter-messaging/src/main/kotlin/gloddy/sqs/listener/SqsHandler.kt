package gloddy.sqs.listener

import gloddy.sqs.util.MessageParser
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SqsHandler {

    @SqsListener(value = ["\${sqs.queue.apply}"])
    fun handleApplyEvent(message: String) {
        val applyEvent = MessageParser.parseApplyEvent(message)
        println(applyEvent.toString())
    }

    @SqsListener(value = ["\${sqs.queue.group-member}"])
    fun handleGroupMemberEvent(message: String) {
        val groupMemberEvent = MessageParser.parseGroupMemberEvent(message)
    }
}