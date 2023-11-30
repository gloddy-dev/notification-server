package gloddy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncConfiguration {

    companion object {
        private const val PUSH_THREAD_NAME_PREFIX = "PUSH-THREAD-"
    }

    @Bean(name = ["pushThreadPoolTaskExecutor"])
    fun pushThreadPoolTaskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.setThreadNamePrefix(PUSH_THREAD_NAME_PREFIX)
        executor.corePoolSize = 9
        executor.maxPoolSize = 9
        return executor
    }
}