package com.company;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class ToDoManagerTests {
    @Test
    public void serialize_todo() {
        var mng = new ToDoManager();

        var todo = new ToDo(false,
                "test",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new Date());

        var res = mng.save(todo);

        System.out.println(res);
    }

    @Test
    public void deserialize_todo() {
        var mng = new ToDoManager();

        var todo = new ToDo(false,
                "test",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new Date());

        var res = mng.save(todo);

        var todo2 = mng.load(res);

        System.out.println(todo2.getName());
    }
}
