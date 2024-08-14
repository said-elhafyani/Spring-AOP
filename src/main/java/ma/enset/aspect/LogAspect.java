package ma.enset.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());
//    @Around("execution(* ma.enset.service..*(..))")
    @Around("@annotation(ma.enset.aspect.Log)")
     public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("From Logging Aspects ... Before "+proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("From Logging Aspects ... After "+proceedingJoinPoint.getSignature());
        logger.info("Time taken : "+(endTime - startTime));
        return result;
    }
}
