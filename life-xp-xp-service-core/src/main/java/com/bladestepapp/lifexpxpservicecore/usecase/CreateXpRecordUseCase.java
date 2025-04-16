package com.bladestepapp.lifexpxpservicecore.usecase;

import com.bladestepapp.lifexpxpservicecore.command.CreateXpRecordCommand;
import com.bladestepapp.lifexpxpservicecore.model.CreateXpRecordResponseModel;

public interface CreateXpRecordUseCase {

    CreateXpRecordResponseModel execute(CreateXpRecordCommand addXpCommand);
}