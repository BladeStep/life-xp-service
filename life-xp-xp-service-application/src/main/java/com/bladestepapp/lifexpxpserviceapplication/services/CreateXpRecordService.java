package com.bladestepapp.lifexpxpserviceapplication.services;

import com.bladestepapp.lifexpxpservicecore.command.CreateXpRecordCommand;
import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.lifexpxpservicecore.domain.XpActivity;
import com.bladestepapp.lifexpxpservicecore.exception.ActivityNotFoundException;
import com.bladestepapp.lifexpxpservicecore.exception.UserNotFoundException;
import com.bladestepapp.lifexpxpservicecore.model.CreateXpRecordResponseModel;
import com.bladestepapp.lifexpxpservicecore.port.gateway.GetActivityPort;
import com.bladestepapp.lifexpxpservicecore.port.gateway.GetUserPort;
import com.bladestepapp.lifexpxpservicecore.port.persistence.GetDailyUserXpPort;
import com.bladestepapp.lifexpxpservicecore.port.persistence.GetTotalUserXpPort;
import com.bladestepapp.lifexpxpservicecore.port.persistence.SaveDailyUserXpPort;
import com.bladestepapp.lifexpxpservicecore.port.persistence.SaveTotalUserXpPort;
import com.bladestepapp.lifexpxpservicecore.port.persistence.SaveXpActivityPort;
import com.bladestepapp.lifexpxpservicecore.usecase.CreateXpRecordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateXpRecordService implements CreateXpRecordUseCase {

    private final SaveXpActivityPort saveXpActivityPort;
    private final GetDailyUserXpPort dailyUserXpPort;
    private final SaveDailyUserXpPort saveDailyUserXpPort;
    private final GetTotalUserXpPort totalUserXpPort;
    private final SaveTotalUserXpPort saveTotalUserXpPort;
    private final GetActivityPort getActivityPort;
    private final GetUserPort getUserPort;

    @Override
    public CreateXpRecordResponseModel execute(CreateXpRecordCommand command) {
        validateUserAndActivity(command);

        long xpGained = calculateXpGained(command);
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

        getActivityPort.find(activityId)
                .orElseThrow(() -> new ActivityNotFoundException("Activity with id " + activityId + " not found"));

        getUserPort.find(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
    }

    private long calculateXpGained(CreateXpRecordCommand command) {
        Activity activity = getActivityPort.find(command.getActivityId()).orElseThrow();
        return (long) (command.getUnitCount() * activity.getBaseXp());
    }

    private void saveXpRecords(UUID userId, long xpGained, XpActivity xpActivity) {
        saveXpActivityPort.save(xpActivity);

        long newDailyXp = dailyUserXpPort.getForToday(userId) + xpGained;
        saveDailyUserXpPort.saveForToday(userId, newDailyXp);

        long newTotalXp = totalUserXpPort.get(userId) + xpGained;
        saveTotalUserXpPort.save(userId, newTotalXp);
    }

    private CreateXpRecordResponseModel buildResponse(UUID userId) {
        long currentDailyXp = dailyUserXpPort.getForToday(userId);
        long currentTotalXp = totalUserXpPort.get(userId);
        return new CreateXpRecordResponseModel(currentDailyXp, currentTotalXp);
    }
}