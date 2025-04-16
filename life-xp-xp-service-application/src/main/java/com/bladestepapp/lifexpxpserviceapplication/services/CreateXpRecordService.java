package com.bladestepapp.lifexpxpserviceapplication.services;

import com.bladestepapp.lifexpxpservicecore.command.CreateXpRecordCommand;
import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.lifexpxpservicecore.domain.XpActivity;
import com.bladestepapp.lifexpxpservicecore.exception.ActivityNotFoundException;
import com.bladestepapp.lifexpxpservicecore.exception.UserNotFoundException;
import com.bladestepapp.lifexpxpservicecore.model.CreateXpRecordResponseModel;
import com.bladestepapp.lifexpxpservicecore.port.gateway.GetActivityPort;
import com.bladestepapp.lifexpxpservicecore.port.gateway.GetUserPort;
import com.bladestepapp.lifexpxpservicecore.port.persistence.*;
import com.bladestepapp.lifexpxpservicecore.usecase.CreateXpRecordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateXpRecordService implements CreateXpRecordUseCase {

    private final SaveXpActivityPort xpActivityPort;
    private final GetDailyXpPort dailyXpPort;
    private final SaveDailyXpPort saveDailyXpPort;
    private final GetTotalXpPort totalXpPort;
    private final SaveTotalXpPort saveTotalXpPort;
    private final GetActivityPort activityPort;
    private final GetUserPort userPort;

    @Override
    public CreateXpRecordResponseModel execute(CreateXpRecordCommand command) {
        validateUserAndActivity(command);

        int xpGained = calculateXpGained(command);
        XpActivity xpActivity = XpActivity.create(
                command.getUserId(),
                command.getActivityId(),
                xpGained);

        saveXpRecords(command.getUserId(), xpGained, xpActivity);

        return buildResponse(command.getUserId());
    }

    private void validateUserAndActivity(CreateXpRecordCommand command) {
        UUID activityId = command.getActivityId();
        UUID userId = command.getUserId();

        activityPort.find(activityId)
                .orElseThrow(() -> new ActivityNotFoundException("Activity with id " + activityId + " not found"));

        userPort.find(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
    }

    private int calculateXpGained(CreateXpRecordCommand command) {
        Activity activity = activityPort.find(command.getActivityId()).orElseThrow();
        return (int) (command.getUnitCount() * activity.getBaseXp());
    }

    private void saveXpRecords(UUID userId, int xpGained, XpActivity xpActivity) {
        xpActivityPort.save(xpActivity);

        int newDailyXp = dailyXpPort.get(userId) + xpGained;
        saveDailyXpPort.save(userId, newDailyXp);

        int newTotalXp = totalXpPort.get(userId) + xpGained;
        saveTotalXpPort.save(userId, newTotalXp);
    }

    private CreateXpRecordResponseModel buildResponse(UUID userId) {
        int currentDailyXp = dailyXpPort.get(userId);
        int currentTotalXp = totalXpPort.get(userId);
        return new CreateXpRecordResponseModel(currentDailyXp, currentTotalXp);
    }
}