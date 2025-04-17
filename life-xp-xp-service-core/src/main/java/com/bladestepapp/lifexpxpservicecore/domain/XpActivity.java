package com.bladestepapp.lifexpxpservicecore.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class XpActivity {

    private UUID userId;

    private UUID activityId;

    private long xp;

    public static XpActivity create(UUID userId, UUID activityId, long xp){
        return XpActivity.builder()
                .userId(userId)
                .activityId(activityId)
                .xp(xp)
                .build();
    }
}
