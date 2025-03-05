package com.bladestepapp.lifexpxpserrviceapi.mappers;

import com.bladestepapp.lifexpxpservicecore.commands.AddXpForActivityCommand;
import com.bladestepapp.model.AddXpForActivityRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface XpMapper {

    AddXpForActivityCommand map(AddXpForActivityRequest xpAddPostRequest);
}
