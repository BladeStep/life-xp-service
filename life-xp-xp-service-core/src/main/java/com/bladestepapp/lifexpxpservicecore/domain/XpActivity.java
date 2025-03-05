package com.bladestepapp.lifexpxpservicecore.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class XpActivity {

    private UUID userId;

    private UUID activityId;

    private Integer xp;

    public static XpActivity create(UUID userId, UUID activityId, Integer xp){
        return XpActivity.builder()
                .userId(userId)
                .activityId(activityId)
                .xp(xp)
                .build();
    }
}
