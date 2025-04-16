package com.bladestepapp.lifexpxpserviceinfrastructure.adapter;

import com.bladestepapp.lifexpxpservicecore.domain.XpActivity;
import com.bladestepapp.lifexpxpservicecore.port.persistence.SaveXpActivityPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.XpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.persistence.XpEntriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class XpActivityCassandraWriteAdapter implements SaveXpActivityPort {

    private final XpEntriesRepository xpEntriesRepository;

    @Override
    public void save(XpActivity xpActivity) {
        XpEntry xpEntry = new XpEntry(xpActivity.getUserId(), xpActivity.getActivityId(), xpActivity.getXp());
        xpEntriesRepository.save(xpEntry);
    }
}