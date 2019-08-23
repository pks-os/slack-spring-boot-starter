package com.kreait.slack.api.contract.jackson.group.reminders

import com.kreait.slack.api.contract.jackson.common.InstantSample
import com.kreait.slack.api.contract.jackson.group.reminders.common.Reminder

fun Reminder.Companion.sample(): Reminder {
    return Reminder(InstantSample.sample(), "", "", false, "", InstantSample.sample(), "")
}
