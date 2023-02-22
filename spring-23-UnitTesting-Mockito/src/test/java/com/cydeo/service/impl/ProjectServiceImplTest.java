package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test(){
        //Stubbing - define behaviour
        //GIVEN when  I run getByProjectCode I want to return some new project entity
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());
        /*when(projectMapper.convertToDto(new Project())).thenReturn(new ProjectDTO());           can do both ways*/
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        //WHEN
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());
        //THEN
        InOrder inOrder = inOrder(projectRepository, projectMapper); //check order
        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));
        assertNotNull(projectDTO);//confirm that the end result is not null
    }

    @Test
    void getByProjectCode_ExceptionTest(){
        //GIVEN
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project not found"));
        //WHEN                              expect this exception  when -> happens
        Throwable throwable = assertThrows(NoSuchElementException.class,()->projectService.getByProjectCode(""));
        //THEN
        verify(projectRepository).findByProjectCode("");//order of the exception matters and we check it here
        verify(projectMapper, never()).convertToDto(any(Project.class));//check if this has never been run due to exception
        assertEquals("Project not found", throwable.getMessage());//whether it is correct exception

    }

}