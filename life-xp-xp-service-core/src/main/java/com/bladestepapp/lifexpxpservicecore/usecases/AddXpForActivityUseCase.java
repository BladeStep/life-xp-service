package com.bladestepapp.lifexpxpservicecore.usecases;

import com.bladestepapp.lifexpxpservicecore.commands.AddXpForActivityCommand;

public interface AddXpForActivityUseCase {

    Integer addXpForActivity(AddXpForActivityCommand addXpCommand);
}
