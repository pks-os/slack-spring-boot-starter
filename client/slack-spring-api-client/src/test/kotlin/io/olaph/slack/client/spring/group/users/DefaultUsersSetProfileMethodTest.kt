package io.olaph.slack.client.spring.group.users

import io.olaph.slack.client.spring.MockServerHelper
import io.olaph.slack.client.spring.Verifier
import io.olaph.slack.client.spring.group.RestTemplateFactory
import io.olaph.slack.dto.jackson.group.users.ErrorUsersSetProfileResponse
import io.olaph.slack.dto.jackson.group.users.SuccessfulUsersSetProfileResponse
import io.olaph.slack.dto.jackson.group.users.sample
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.web.client.RestTemplate

class DefaultUsersSetProfileMethodTest {
    private lateinit var mockTemplate: RestTemplate

    @BeforeEach
    fun setup() {
        mockTemplate = RestTemplateFactory.slackTemplate()
    }

    @Test
    @DisplayName("Users.setProfile Failure")
    fun UserSetProfileFailure() {
        val response = ErrorUsersSetProfileResponse.sample()
        val mockServer = MockServerHelper.buildMockRestServer(mockTemplate, "users.profile.set", response)
        val verifier = Verifier(response)

        DefaultUsersSetProfileMethod("", mockTemplate)
                .onFailure { verifier.set(it) }
                .invoke()
        mockServer.verify()
        verifier.verify()
    }

    @Test
    @DisplayName("Users.setProfile Success")
    fun UserSetProfileSuccess() {
        val response = SuccessfulUsersSetProfileResponse.sample()
        val mockServer = MockServerHelper.buildMockRestServer(mockTemplate, "users.profile.set", response)
        val verifier = Verifier(response)

        DefaultUsersSetProfileMethod("", mockTemplate)
                .onSuccess { verifier.set(it) }
                .invoke()
        mockServer.verify()
        verifier.verify()
    }
}
