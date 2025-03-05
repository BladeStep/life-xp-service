package com.bladestepapp.lifexpxpserrviceapi.controllers;

import com.bladestepapp.api.XpApi;
import com.bladestepapp.lifexpxpserrviceapi.mappers.XpMapper;
import com.bladestepapp.lifexpxpservicecore.commands.AddXpForActivityCommand;
import com.bladestepapp.lifexpxpservicecore.usecases.AddXpForActivityUseCase;
import com.bladestepapp.model.AddXpForActivityRequest;
import com.bladestepapp.model.AddXpForActivityResponseDto;
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

    private final XpMapper xpMapper;

    private final AddXpForActivityUseCase addXpForActivityUseCase;

    @Override
    public ResponseEntity<AddXpForActivityResponseDto> addXpForActivity(AddXpForActivityRequest addXpForActivityRequest) {
        AddXpForActivityCommand command = xpMapper.map(addXpForActivityRequest);
        Integer totalActivityXp = addXpForActivityUseCase.addXpForActivity(command);
        AddXpForActivityResponseDto responseDto = new AddXpForActivityResponseDto().totalXp(totalActivityXp);
        return ResponseEntity.ok(responseDto);
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
