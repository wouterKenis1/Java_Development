package wouter.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Achievement {
    int squareCount = 0;

    @After("execution(* *.square(..))")
    public void afterSquare(){

        squareCount++;
        if(squareCount == 5){
            System.out.println("5 square achievement");
        }
    }

}
