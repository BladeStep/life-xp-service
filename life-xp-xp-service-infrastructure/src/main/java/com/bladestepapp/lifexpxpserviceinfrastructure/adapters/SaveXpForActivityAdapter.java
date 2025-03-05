package com.bladestepapp.lifexpxpserviceinfrastructure.adapters;

import com.bladestepapp.lifexpxpservicecore.domain.XpActivity;
import com.bladestepapp.lifexpxpservicecore.ports.SaveXpForActivityPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.XpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.repositories.XpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveXpForActivityAdapter implements SaveXpForActivityPort {

    private final XpRepository xpRepository;

    @Override
    public void saveXpActivity(XpActivity xpActivity) {
        XpEntry xpEntry = new XpEntry(xpActivity.getUserId(), xpActivity.getActivityId(), xpActivity.getXp());
        xpRepository.save(xpEntry);
    }
}