package com.bladestepapp.lifexpxpserviceinfrastructure.gateway;

import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.UserResponseModel;
import com.bladestepapp.lifexpxpserviceinfrastructure.http.properties.UserServiceProperties;
import com.bladestepapp.model.MonoUserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserGateway {

    private final WebClient client;

    private final UserServiceProperties userServiceProperties;

    public Optional<UserResponseModel> find(UUID id) {
        try {
            ResponseEntity<MonoUserResponseDto> responseEntity = client.get()
                    .uri(userServiceProperties.getUserPath(), id)
                    .retrieve()
                    .toEntity(MonoUserResponseDto.class)
                    .block();

            if (responseEntity == null || !responseEntity.hasBody()) {
                return Optional.empty();
            }

            MonoUserResponseDto responseDto = responseEntity.getBody();
            if (!responseDto.getIsSuccess() || responseDto.getData() == null) {
                return Optional.empty();
            }

            return Optional.of(new UserResponseModel(
                    responseDto.getData().getId(),
                    responseDto.getData().getName(),
                    responseDto.getData().getEmail()
            ));

        } catch (WebClientResponseException.NotFound e) {
            log.warn("User not found. ID: {}, Response: {}", id, e.getResponseBodyAsString());
            return Optional.empty();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(
                    e.getStatusCode(),
                    "User service error: " + e.getResponseBodyAsString(),
                    e
            );
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed to call user service",
                    e
            );
        }
    }
}
