package com.inn.bookmanagement.service;

import com.inn.bookmanagement.util.IntentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    private Logger logger = LoggerFactory.getLogger(ActionService.class);

    public String listActions() {
        logger.info("executing intent {}", IntentUtil.LIST_ACTIONS);

        StringBuilder response = new StringBuilder();

        response.append("This is the book management AI chat-bot action control. ");
        response.append("I can tell you about authors I know about, or you can tell me which type of book you are interested in. ");
        response.append("Based on your response, we can go forward with the process. ");
        response.append("So Please tell me, what would you like to know?");

        return response.toString();
    }

}
