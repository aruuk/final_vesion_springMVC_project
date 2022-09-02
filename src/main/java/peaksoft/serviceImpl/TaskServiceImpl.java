package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.TaskDAO;
import peaksoft.model.Task;
import peaksoft.service.TaskService;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }


    @Override
    public void saveTask(Task task, Long id) {
        taskDAO.saveTask(task,id );
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskDAO.updateTask(id, task);
    }

    @Override
    public void deleteTask(Long id) {
        taskDAO.deleteTask(id);
    }

    @Override
    public List<Task> getTasks(Long id) {
        return taskDAO.getTasks(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDAO.getTaskById(id);
    }
}
