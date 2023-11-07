package gloddy.dynamodb.fcmToken

import com.amazonaws.services.dynamodbv2.datamodeling.*
import gloddy.dynamodb.config.LocalDateTimeConverter
import java.time.LocalDateTime

@DynamoDBTable(tableName = "fcm_token")
class FCMTokenEntity(
    @field:DynamoDBHashKey(attributeName = "user_id")
    var userId: String = "",

    @field:DynamoDBAttribute(attributeName = "token")
    var token: String = "",

    @field:DynamoDBAttribute(attributeName = "created_at")
    @field:DynamoDBTypeConverted(converter = LocalDateTimeConverter::class)
    var createdAt: LocalDateTime = LocalDateTime.now()
)