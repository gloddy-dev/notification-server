package gloddy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncThreadConfiguration {

    companion object {
        private const val THREAD_NAME_PREFIX = "ASYNC-THREAD-"
    }

    @Bean
    fun asyncThreadTaskExecutor(): Executor {
        return ThreadPoolTaskExecutor().apply {
                corePoolSize = 9
                maxPoolSize = 9
                setThreadNamePrefix(THREAD_NAME_PREFIX)
            }
    }
}