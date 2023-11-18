package gloddy.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowCredentials(true)
            .allowedOrigins(
                "http://localhost:3000",
                "https://gloddy.vercel.app",
                "https://gloddy-git-develop-gueit214.vercel.app"
            )
            .allowedMethods("*")
            .allowedHeaders("*")
    }
}