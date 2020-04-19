package it.reply.iriscube.unito.app.mock

import it.reply.iriscube.unito.datasource.api.APIClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Created by Reply on 2020-04-18.
 */
class MockWebServerTestRule : TestRule {

    companion object {
        const val PORT = 8000
    }

    lateinit var mockWebServer: MockWebServer

    override fun apply(base: Statement, description: Description?): Statement {
        return MockWebServerStatement(base)
    }

    inner class MockWebServerStatement constructor(
        private val baseStatement: Statement
    ) : Statement() {

        override fun evaluate() {
            mockWebServer = MockWebServer()
            mockWebServer.start(PORT)
            APIClient.baseUrl = "http://localhost:$PORT/"
            // Continue test execution
            baseStatement.evaluate()
        }
    }
}