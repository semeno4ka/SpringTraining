package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;
    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L})
    void findById_Test(long id){
        //Given
        Task task =new Task();            //since findById returns Optional<Task>
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());
        //can put any(Task.class)in convertToDTO, but this test checks the same task we created
        //WHEN real action happens
        //TaskDTO taskDTO=taskService.findBYId(id); will be required if you need to assert particular result
        taskService.findById(id);//line that mocks real test, it's performance, not result
        //Then (Assert and verify checking methods)
        verify(taskRepository).findById(id);//check injected mocks
        verify(taskMapper).convertToDto(task);//in real order simulating real results
        //assertNotNull(taskDTO);
        // if you do not need to assert the result, no need to assign taskService.findBYId to TaskDTO taskDTO

    }


    @Test
    void findById_BDD_Test(){
        Task task =new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        taskService.findById(anyLong());

        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);
    }


}