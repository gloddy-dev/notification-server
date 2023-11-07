package gloddy.dynamodb.config

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
import gloddy.notification.NotificationType

class NotificationTypeConverter : DynamoDBTypeConverter<String, NotificationType> {
    override fun convert(value: NotificationType): String {
        return value.name
    }

    override fun unconvert(value: String): NotificationType {
        return NotificationType.of(value)
    }
}