package gloddy.dynamodb.config

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

class TableNameResolver(
    private val stage: String
) : DynamoDBMapperConfig.TableNameResolver {

    companion object {
        const val STG: String = "stg"
        const val PRD: String = "prd"
    }

    override fun getTableName(clazz: Class<*>?, config: DynamoDBMapperConfig?): String {

        val tableNameOverride = config?.tableNameOverride
        if (tableNameOverride != null) {
            val tableName = tableNameOverride.tableName
            if (tableName != null)
                return tableName
        }

        val rawTableName = clazz?.getAnnotation(DynamoDBTable::class.java)?.tableName
            ?: throw DynamoDBMappingException("$clazz not annotated with @DynamoDBTable")

        return when (stage) {
            STG -> rawTableName
            PRD -> "${rawTableName}_$stage"
            else -> throw RuntimeException("Invalid stage: $stage")
        }
    }
}