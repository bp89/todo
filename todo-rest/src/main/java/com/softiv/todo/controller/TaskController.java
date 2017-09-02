package com.softiv.todo.controller;

import com.softiv.todo.domain.Task;
import com.softiv.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/tasks")
    @ResponseBody
    public String home() {
        return "tasks";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(ModelMap modelMap, @Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Error";
        } else {
            task = taskRepository.save(task);
            return task.toString();
        }
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam Long id) {
        String output = "";
        if (id != null) {
            output = taskRepository.getOne(id).toString();
        } else {

        }
        return output;
    }
}
