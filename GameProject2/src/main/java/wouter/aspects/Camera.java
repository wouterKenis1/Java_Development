package wouter.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@Aspect
public class Camera {

//    @Before("execution(* wouter.components.Window.paint(..))")
//    public void beforeDraw() throws Throwable{
//        System.out.println("before paint");
//    }

    @Around("execution(* *.draw(..))")
    public void aroundDraw(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("before draw");
        pjp.proceed();
        System.out.println("after draw");

    }
}


// @Around("execution(* *.draw(..)) && !@Target(wouter.components.gameobjects.CustomPointer)")
