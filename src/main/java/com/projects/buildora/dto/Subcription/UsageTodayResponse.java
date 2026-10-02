package com.projects.buildora.dto.Subcription;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokensLimit,
        Integer previewRunning,
        Integer previewLimit
) {

}
