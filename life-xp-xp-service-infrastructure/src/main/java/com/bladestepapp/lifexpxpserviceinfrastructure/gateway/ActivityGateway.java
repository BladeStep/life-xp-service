package com.bladestepapp.lifexpxpserviceinfrastructure.gateway;

import com.bladestepapp.lifexpxpservicecore.exception.ExternalServiceException;
import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.mapper.ActivityGatewayMapper;
import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.ActivityResponseModel;
import com.bladestepapp.lifexpxpserviceinfrastructure.http.ActivityQueryClient;
import com.bladestepapp.model.ActivityResponseDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActivityGateway {

    private final ActivityQueryClient activityQueryClient;

    private final ActivityGatewayMapper mapper;

    public Optional<ActivityResponseModel> find(UUID activityId) {
        try {
            ResponseEntity<ActivityResponseDto> response = activityQueryClient.getActivityById(activityId);
            if (response.getStatusCode().is2xxSuccessful()) {
                return Optional.of(mapper.map(response.getBody()));
            }
        } catch (FeignException.NotFound e) {
            return Optional.empty();
        } catch (FeignException e) {
            log.error("Feign ошибка при вызове ActivityQueryClient", e);
            throw new ExternalServiceException("activity-service", e.status(), "Ошибка от внешнего сервиса", e);
        } catch (Exception e) {
            log.error("Неожиданная ошибка при вызове ActivityQueryClient", e);
            throw new ExternalServiceException("activity-service", 500, "Непредвиденная ошибка", e);
        }
        return Optional.empty();
    }
}