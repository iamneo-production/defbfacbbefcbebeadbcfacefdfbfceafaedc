package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task saveTask(Task task){
        repository.save(task);
        return task;
    }

    public Task updatetaskStatus(String taskId){
        Optional<Task> task = repository.findByTaskId(taskId);
        if(task.isPresent()){
            task.get().setTaskStatus("Accepted");
            repository.save(task.get());
            return task.get();
        }
        return null;
        
    }


    public String deleteTask(String id){
        Optional<Taskentity> taskentity = repository.findByTaskId(id);
        if(taskentity.isPresent()){
            repository.deleteByTaskId(id);
            return"Task Deleted Successfully";
        }
        return "User not Found";
    }


    public List<Taskentity> getallTasks(){
        return repository.findAll();
    }

    public Taskentity gettaskbyid(String id){
        Optional<Taskentity> taskentity = repository.findByTaskId(id);
        if(taskentity.isPresent()){
            return taskentity.get();
        }
        return null;
    }

    

}