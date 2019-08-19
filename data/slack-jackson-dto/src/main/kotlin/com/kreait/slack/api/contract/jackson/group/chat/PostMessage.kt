package com.kreait.slack.api.contract.jackson.group.chat

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.kreait.slack.api.contract.jackson.common.messaging.Attachment
import com.kreait.slack.api.contract.jackson.common.messaging.Block
import com.kreait.slack.api.contract.jackson.util.InstantToString
import com.kreait.slack.api.contract.jackson.util.JacksonDataClass
import java.time.Instant

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ok",
        visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(value = SuccessfulPostMessageResponse::class, name = "true"),
        JsonSubTypes.Type(value = ErrorPostMessageResponse::class, name = "false")
)
@JacksonDataClass
sealed class PostMessageResponse constructor(@JsonProperty("ok") open val ok: Boolean)

@JacksonDataClass
data class SuccessfulPostMessageResponse constructor(override val ok: Boolean,
                                                     @JsonProperty("channel") val channel: String,
                                                     @InstantToString @JsonProperty("ts") val timestamp: Instant,
                                                     @JsonProperty("message") val message: Message? = null) : PostMessageResponse(ok) {
    companion object
}

data class Message(
        @JsonProperty("type") val type: String? = null,
        @JsonProperty("subtype") val subtype: String? = null,
        @JsonProperty("text") val text: String? = null,
        @InstantToString @JsonProperty("ts") val timestamp: Instant,
        @JsonProperty("username") val username: String? = null,
        @JsonProperty("attachments") val attachments: List<Attachment>? = listOf(),
        @JsonProperty("bot_id") val botId: String? = null) {
    companion object
}

@JacksonDataClass
data class ErrorPostMessageResponse constructor(override val ok: Boolean,
                                                @JsonProperty("error") val error: String) : PostMessageResponse(ok) {
    companion object
}

@JacksonDataClass
data class PostMessageRequest constructor(@JsonProperty("text") val text: String,
                                          @JsonProperty("channel") val channel: String,
                                          @JsonProperty("attachments") val attachments: List<Attachment>? = null,
                                          @JsonProperty("blocks") val blocks: List<Block>? = null,
                                          @JsonProperty("as_user") val asUser: Boolean? = false,
                                          @JsonProperty("username") val username: String? = null,
                                          @JsonProperty("icon_emoji") val iconEmoji: String? = null,
                                          @JsonProperty("icon_url") val iconUrl: String? = null,
                                          @JsonProperty("link_names") val linkNames: Boolean = true,
                                          @JsonProperty("mrkdwn") val markDown: Boolean = true,
                                          @JsonProperty("parse") val parse: String? = null,
                                          @JsonProperty("reply_broadcast") val replyBroadcast: Boolean = false,
                                          @InstantToString @JsonProperty("thread_ts") val threadTs: Instant? = null,
                                          @JsonProperty("unfurl_links") val unfurlLinks: Boolean = false,
                                          @JsonProperty("unfurl_media") val unfurlMedia: Boolean = true) {
    companion object
}







