package com.kreait.slack.api.contract.jackson.group.users

import com.kreait.slack.api.contract.jackson.common.types.Member
import com.kreait.slack.api.contract.jackson.common.types.sample


fun SuccessfulInfoResponse.Companion.sample(): SuccessfulInfoResponse {
    return SuccessfulInfoResponse(true, Member.sample())
}

fun ErrorInfoResponse.Companion.sample(): ErrorInfoResponse {
    return ErrorInfoResponse(false, "")
}

fun InfoRequest.Companion.sample(): InfoRequest {
    return InfoRequest("", false)
}
