package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;//l4j => logging facade for java
import org.springframework.stereotype.Component;

@Aspect
@Component// both annotations required to work with Aspect
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    //is used to put info into Console(just like System.out.print)


    //Step 1.creates jointpoint, to define methods with logging
    // Log info before any method in courseController
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut(){
// }
//    //Step 2. create advice to specify what will be done before or after any method from pointcut class
//     @Before("myPointcut()")
//     public void log(){
//     logger.info("This log is printed in console before any CourseController method run");
//}
    //Can be done in Single step, but is better to separate to use myPointcut in other logs
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log() {
//        logger.info("This log is printed in console before any CourseController method run");
//    }

   //When you want one specific method to be your jointpoint
    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    public void courseRepositoryFindByIdPC(){}
   // What need to happen before the method (findById from Repo) gets executed
    @Before("courseRepositoryFindByIdPC()")
    public void beforeCourseRepoFindById(JoinPoint joinPoint){// with this parameter we can get info about joinPoint methods
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
                joinPoint.getSignature(),//will replace first parameter in {Method}
                joinPoint.getArgs(),// will replace first parameter in {Arguments}
                joinPoint.getTarget());// will replace first parameter in {Target}
    }
}
