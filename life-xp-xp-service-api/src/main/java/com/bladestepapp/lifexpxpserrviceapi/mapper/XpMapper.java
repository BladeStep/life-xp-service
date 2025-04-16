package com.bladestepapp.lifexpxpserrviceapi.mapper;

import com.bladestepapp.lifexpxpservicecore.command.CreateXpRecordCommand;
import com.bladestepapp.lifexpxpservicecore.model.CreateXpRecordResponseModel;
import com.bladestepapp.model.CreateXpRecordRequest;
import com.bladestepapp.model.CreateXpRecordResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface XpMapper {

    CreateXpRecordCommand map(CreateXpRecordRequest xpAddPostRequest);

    CreateXpRecordResponse map(CreateXpRecordResponseModel createXpRecordResponseModel);
}