package com.bladestepapp.lifexpxpserrviceapi.controllers;

import com.bladestepapp.api.XpApi;
import com.bladestepapp.model.XpAddPost200Response;
import com.bladestepapp.model.XpAddPostRequest;
import com.bladestepapp.model.XpHistoryUserIdGet200Response;
import com.bladestepapp.model.XpLeaderboardGet200Response;
import com.bladestepapp.model.XpResetPost200Response;
import com.bladestepapp.model.XpResetPostRequest;
import com.bladestepapp.model.XpStatsUserIdGet200Response;
import com.bladestepapp.model.XpStatsUserIdLastDaysGet200Response;
import com.bladestepapp.model.XpUserIdGet200Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class XpController implements XpApi {

    @Override
    public ResponseEntity<XpAddPost200Response> xpAddPost(XpAddPostRequest xpAddPostRequest) {
        return XpApi.super.xpAddPost(xpAddPostRequest);
    }

    @Override
    public ResponseEntity<XpHistoryUserIdGet200Response> xpHistoryUserIdGet(UUID userId) {
        return XpApi.super.xpHistoryUserIdGet(userId);
    }

    @Override
    public ResponseEntity<XpLeaderboardGet200Response> xpLeaderboardGet() {
        return XpApi.super.xpLeaderboardGet();
    }

    @Override
    public ResponseEntity<XpResetPost200Response> xpResetPost(XpResetPostRequest xpResetPostRequest) {
        return XpApi.super.xpResetPost(xpResetPostRequest);
    }

    @Override
    public ResponseEntity<XpStatsUserIdGet200Response> xpStatsUserIdGet(UUID userId, LocalDate from, LocalDate to) {
        return XpApi.super.xpStatsUserIdGet(userId, from, to);
    }

    @Override
    public ResponseEntity<XpStatsUserIdLastDaysGet200Response> xpStatsUserIdLastDaysGet(UUID userId, Integer days) {
        return XpApi.super.xpStatsUserIdLastDaysGet(userId, days);
    }

    @Override
    public ResponseEntity<XpUserIdGet200Response> xpUserIdGet(UUID userId) {
        return XpApi.super.xpUserIdGet(userId);
    }
}
