package com.bladestepapp.lifexpxpserrviceapi.controller;

import com.bladestepapp.api.XpApi;
import com.bladestepapp.lifexpxpserrviceapi.mapper.XpMapper;
import com.bladestepapp.lifexpxpservicecore.command.CreateXpRecordCommand;
import com.bladestepapp.lifexpxpservicecore.model.CreateXpRecordResponseModel;
import com.bladestepapp.lifexpxpservicecore.usecase.CreateXpRecordUseCase;
import com.bladestepapp.model.CreateXpRecordRequest;
import com.bladestepapp.model.CreateXpRecordResponse;
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

    private final XpMapper mapper;

    private final CreateXpRecordUseCase createXpRecordUseCase;

    @Override
    public ResponseEntity<CreateXpRecordResponse> createXpRecord(CreateXpRecordRequest createXpRecordRequest) {
        CreateXpRecordCommand command = mapper.map(createXpRecordRequest);
        CreateXpRecordResponseModel createXpRecordResponseModel = createXpRecordUseCase.execute(command);
        CreateXpRecordResponse createXpRecordResponse = mapper.map(createXpRecordResponseModel);
        return ResponseEntity.ok(createXpRecordResponse);
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
