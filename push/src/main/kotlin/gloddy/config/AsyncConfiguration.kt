package gloddy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncConfiguration : AsyncConfigurer {

    companion object {
        private const val PUSH_THREAD_NAME_PREFIX = "PUSH-ASYNC-THREAD-"
    }

    @Bean(name = ["PUSH-EVENT-ASYNC-EXECUTOR"])
    override fun getAsyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.setThreadNamePrefix(PUSH_THREAD_NAME_PREFIX)
        executor.corePoolSize = 2
        executor.maxPoolSize = 10
        executor.queueCapacity = 5
        executor.initialize()
        return executor
    }
}