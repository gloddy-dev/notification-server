package gloddy.dynamodb.notification

import com.amazonaws.services.dynamodbv2.datamodeling.*
import gloddy.dynamodb.config.LocalDateTimeConverter
import gloddy.dynamodb.config.NotificationTypeConverter
import gloddy.notification.NotificationType
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.*


@DynamoDBTable(tableName = "notification")
class NotificationEntity(
    @field:DynamoDBHashKey
    var id: String = UUID.randomUUID().toString(),

    @field:DynamoDBAttribute(attributeName = "user_id")
    @field:DynamoDBIndexHashKey(globalSecondaryIndexName = "user_id-created_at-index")
    var userId: String = "",

    @field:DynamoDBAttribute(attributeName = "redirect_id")
    var redirectId: String = "",

    @field:DynamoDBAttribute(attributeName = "title")
    var title: String = "",

    @field:DynamoDBAttribute(attributeName = "content")
    var content: String = "",

    @field:DynamoDBAttribute(attributeName = "type")
    @field:DynamoDBTypeConverted(converter = NotificationTypeConverter::class)
    var type: NotificationType? = null,

    @field:DynamoDBAttribute(attributeName = "image")
    var image: String = "",

    @field:DynamoDBAttribute(attributeName = "created_at")
    @field:DynamoDBTypeConverted(converter = LocalDateTimeConverter::class)
    @field:DynamoDBIndexRangeKey(globalSecondaryIndexName = "user_id-created_at-index")
    var createdAt: LocalDateTime = now()
)