package com.kreait.slack.api.group.users

import com.kreait.slack.api.contract.jackson.group.users.ErrorInfoResponse
import com.kreait.slack.api.contract.jackson.group.users.InfoRequest
import com.kreait.slack.api.contract.jackson.group.users.SuccessfulInfoResponse
import com.kreait.slack.api.group.ApiCallMethod

/**
 * Abstract representation of an slack api operation
 * https://api.slack.com/methods/users.info
 */
@Suppress("UNCHECKED_CAST")
abstract class UsersInfoMethod : ApiCallMethod<UsersInfoMethod, SuccessfulInfoResponse, ErrorInfoResponse, InfoRequest>()

