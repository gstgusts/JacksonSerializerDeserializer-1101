package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ToDoManager {
    public String save(ToDo toDo) {
        var mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            return mapper.writerWithDefaultPrettyPrinter()
                         .writeValueAsString(toDo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ToDo load(String str) {
        var mapper = new ObjectMapper();
        try {
            return mapper.readValue(str, ToDo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
