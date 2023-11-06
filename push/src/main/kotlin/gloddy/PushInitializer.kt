package gloddy

import org.springframework.beans.factory.annotation.Value
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import kotlin.jvm.Throws

@Component
class PushInitializer(
    @Value("\${fcm.certification-path}")
    private val googleCredentialsPath: String
) {
    @PostConstruct
    @Throws(Exception::class)
    fun initialize() {
        val resource = ClassPathResource(googleCredentialsPath)
        resource.inputStream.use {
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(it))
                .build()

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options)
            }
        }
    }
}