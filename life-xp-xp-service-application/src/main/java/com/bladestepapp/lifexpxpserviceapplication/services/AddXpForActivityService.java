package com.bladestepapp.lifexpxpserviceapplication.services;

import com.bladestepapp.lifexpxpservicecore.commands.AddXpForActivityCommand;
import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.lifexpxpservicecore.domain.XpActivity;
import com.bladestepapp.lifexpxpservicecore.ports.GetActivityPort;
import com.bladestepapp.lifexpxpservicecore.ports.SaveXpForActivityPort;
import com.bladestepapp.lifexpxpservicecore.usecases.AddXpForActivityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddXpForActivityService implements AddXpForActivityUseCase {

    private final SaveXpForActivityPort saveXpForActivityPort;

    private final GetActivityPort getActivityPort;

    @Override
    public Integer addXpForActivity(AddXpForActivityCommand addXpCommand) {
        Activity activity = getActivityPort.get(addXpCommand.getActivityId());
        int xpGained = (int) (addXpCommand.getHours() * activity.getBaseXp());

        XpActivity xpActivity = XpActivity.create(
                addXpCommand.getUserId(),
                addXpCommand.getActivityId(),
                xpGained);

        saveXpForActivityPort.saveXpActivity(xpActivity);
        return -1;
    }

    private double getXpMultiplierFromActivityService(UUID activityId) {
        return 2; //TODO execution from Activity Service
    }
}
