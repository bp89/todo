package com.softiv.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.softiv.todo.domain.Task;
import com.softiv.todo.repository.TaskRepository;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@Log
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/list")
    @SneakyThrows
    public String home() {
        List<Task> tasks = taskRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tasks);
        return jsonInString;
    }

    @RequestMapping(value = "/create", consumes="application/json", method = RequestMethod.POST)
    @SneakyThrows
    public String create(@Valid @RequestBody Task task, BindingResult bindingResult) {
        System.out.println("task"+task);
        if (bindingResult.hasErrors()) {
            log.info("Errors"+bindingResult.getAllErrors());
            return "Error";
        } else {
            task = taskRepository.save(task);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
            return jsonInString;
        }
    }

    @RequestMapping("/get")
    public String get(@RequestParam Long id) {
        String output = "";
        if (id != null) {
            output = taskRepository.getOne(id).toString();
        }
        return output;
    }


    @RequestMapping("/query")
    public String query(@RequestParam Long id) {
        String output = "";
        if (id != null) {
            output = taskRepository.getOne(id).toString();
        }
        return output;
    }


}
