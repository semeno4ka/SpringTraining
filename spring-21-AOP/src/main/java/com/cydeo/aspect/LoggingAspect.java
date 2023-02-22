package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;//l4j => logging facade for java
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component// both annotations required to work with Aspect
public class LoggingAspect {


    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    //is used to put info into Console(just like System.out.print)


    //Step 1.creates joinpoint, to define methods with logging
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

    //When you want one specific method to be your joinpoint
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC(){}
//   // What need to happen before the method (findById from Repo) gets executed
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepoFindById(JoinPoint joinPoint){// with this parameter we can get info about joinPoint methods
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(),//will replace first parameter in {Method}
//                joinPoint.getArgs(),// will replace first parameter in {Arguments}
//                joinPoint.getTarget());// will replace first parameter in {Target}
//    }

//    @Pointcut("within(com.cydeo.controller..*)")// all methods inside controller package and its subpackage
//    public void anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")//all the methods inside @service annotated classes
//    public void anyServiceOperation(){}
//    //combineTwoPointcuts
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//               joinPoint.getSignature(),//will replace first parameter in {Method}
//               joinPoint.getArgs(),// will replace first parameter in {Arguments}
//               joinPoint.getTarget());// will replace first parameter in {Target}
//    }

//      @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//      public void anyDeleteControllerOperation(){}
//
//     @Before("anyDeleteControllerOperation()")// will work for all methods with @DeleteMapping
//     public void beforeControllerDeleteOperation(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//               joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
// }
//
//     //Custom annotation in use with AOP structure
//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC(){}
//     @Before("loggingAnnotationPC()")// will work for all methods with @LoggingAnnotation
//     public void beforeControllerDeleteOperation(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//               joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
// }
//   @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterGetMappingAnnotation(){}

//    @AfterReturning(pointcut = "afterGetMappingAnnotation()", returning = "result")// returns the actual object, so you can perform actions on it
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint,Object result){
//         logger.info("After -> Method: {}, Result: {}", joinPoint.getSignature(), result.toString());
//    }

//        @AfterReturning(pointcut = "afterGetMappingAnnotation()", returning = "results")// returns the actual object, so you can perform actions on it
//        public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results){
//         logger.info("After -> Method: {}, Result: {}", joinPoint.getSignature(), results.toString());
//    }// have to use courseDTO, instead of Object, because List of Object is not a parent to another List
//

//     @AfterThrowing(pointcut = "afterGetMappingAnnotation()", throwing = "exception")
//     public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception){
//       logger.error("After Throwing -> Method: {}, Exception: {}",
//               joinPoint.getSignature().toShortString(),//toShortString shows only method name
//               exception.getMessage());// will not be shown until exception is thrown
//     }

    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC() {
    }

    @Around("loggingAnnotationPC()")//same as joinPoint but with proceed method
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint) {// can return or stay void
        logger.info("Before -> Method: {} - Parameter: {}",
                proceedingJoinPoint.getSignature().toShortString(),
                proceedingJoinPoint.getArgs());
        Object result = null;
//what happens before real method
        try {
            result = proceedingJoinPoint.proceed();// will run my method annotated with @LoggingAnnotation
            //without proceed the method will never get executed
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
//what happens after method because of 'proceed'()
        logger.info("After -> Method: {} - Result: {}",
                proceedingJoinPoint.getSignature().toShortString(),
                result.toString());
        return result;
    }
}
