package gloddy.dynamodb.config

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class LocalDateTimeConverter : DynamoDBTypeConverter<Date, LocalDateTime> {

    override fun convert(value: LocalDateTime): Date {
        return Date.from(value.toInstant(ZoneOffset.UTC))
    }

    override fun unconvert(value: Date): LocalDateTime {
        return value.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime()
    }
}