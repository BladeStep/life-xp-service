package com.bladestepapp.lifexpxpserviceinfrastructure.http;

import com.bladestepapp.api.ActivityQueryApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "activity-service",
        url = "${activity-service.url}"
)
public interface ActivityQueryClient extends ActivityQueryApi {
}