package kotlin_microservice

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty

var messageText = "Hello!"

fun main(args: Array<String>) {
    // docs for embeddedServer - https://ktor.io/servers/configuration.html#embedded-server
    val env = applicationEngineEnvironment {
        module { main() }
        connector {
            port = 8080
        }
    }
    embeddedServer(Jetty, env).start(wait = true)
}

fun Application.main() {
    install(DefaultHeaders)
    routing {
        get("/") {
            call.respondText(messageText, ContentType.Text.Html)
        }
    }
}
