package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)//enable mockito
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;
    @InjectMocks // will inject mock objects from userMapper and userRepo to userService mock
    UserServiceImpl userService;//test implementation class, not Interface

    @Test
    void findByUserName_Test(){
        //call real method inside main,which is the method I want to test
        userService.findByUserName("harold@manager.com");

        //check if this method ran or not. It checks if Mock userRepo ran or not
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        //interface from Mockito
        InOrder inOrder = inOrder(userRepository,userMapper);//can accept any number of mocks

        //will check the order of execution  in the app: userRepo first, userMapper second
        /*inOrder.verify(userMapper).convertToDto(null); should not be first, because it is run in our method as second*/
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);
    }

}