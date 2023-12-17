package gloddy.dynamodb.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@EnableDynamoDBRepositories(basePackages = ["gloddy.dynamodb.notification", "gloddy.dynamodb.fcmToken"], dynamoDBMapperConfigRef = "dynamoDBMapperConfig")
class DynamoDBConfig(
    @Value("\${amazon.dynamodb.endpoint}") private val endpoint: String,
    @Value("\${amazon.aws.accessKey}") private val accessKey: String,
    @Value("\${amazon.aws.secretKey}") private val secretKey: String,
    @Value("\${amazon.aws.region}") private val region: String,
    @Value("\${stage}") private val stage: String
) {

    @Primary
    @Bean
    fun dynamoDBMapper(amazonDynamoDB: AmazonDynamoDB): DynamoDBMapper {
        return DynamoDBMapper(
            amazonDynamoDB,
            dynamoDBMapperConfig()
        )
    }

    @Bean
    fun dynamoDBMapperConfig(): DynamoDBMapperConfig {
        return DynamoDBMapperConfig.builder()
            .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
            .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.EVENTUAL)
            .withPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy.LAZY_LOADING)
            .withTableNameResolver(tableNameResolver())
            .withBatchWriteRetryStrategy(DynamoDBMapperConfig.DefaultBatchWriteRetryStrategy.INSTANCE)
            .withBatchLoadRetryStrategy(DynamoDBMapperConfig.DefaultBatchLoadRetryStrategy.INSTANCE)
            .withTypeConverterFactory(DynamoDBTypeConverterFactory.standard())
            .withConversionSchema(ConversionSchemas.V2_COMPATIBLE)
            .build()
    }

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        val awsCredentials = BasicAWSCredentials(accessKey, secretKey)
        val awsCredentialsProvider = AWSStaticCredentialsProvider(awsCredentials)
        val endpointConfiguration = AwsClientBuilder.EndpointConfiguration(endpoint, region)
        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(awsCredentialsProvider)
            .withEndpointConfiguration(endpointConfiguration)
            .build()
    }

    @Bean
    fun awsCredentials() = BasicAWSCredentials(accessKey, secretKey)

    @Bean
    @Primary
    fun tableNameResolver() = TableNameResolver(stage)
}