package com.examly.springapp.controller;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class TaskController {
    @Autowired
    private TaskService service;
    
    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task){
        Task output = service.saveTask(task);
        return output;
    }

    @GetMapping("/changeStatus")
    private Task updatetaskStatus(@RequestParam("id") String id){
        return service.updatetaskStatus(id);
    }

    @GetMapping("/deleteTask")
    private String deleteTask(@RequestParam("id") String id){
        return service.deleteTask(id);
    }
    @GetMapping("/alltasks")
    private List<Task> getallTasks(){
        return service.getallTasks();
    }

    @GetMapping("/getTask")
    private Task getTask(@RequestParam("id") String id){
        return service.gettaskbyid(id);
    }
}
