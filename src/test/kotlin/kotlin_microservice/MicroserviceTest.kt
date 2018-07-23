package kotlin_microservice

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.Test
import kotlin.test.assertEquals

class MicroserviceTest {

    @Test
    fun testHello() = withTestApplication(Application::main) {
        messageText = "World!"
        with(handleRequest(HttpMethod.Get, "/")) {
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals(messageText, response.content)
        }
    }

}
