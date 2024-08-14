package ma.enset.aspect;

import ma.enset.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class AuthorizationAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint,SecuredByAspect securedByAspect) throws Throwable {
       String[] roles = securedByAspect.roles();
       boolean authorized = false;
       for (String role : roles) {
           if (SecurityContext.hasRole(role)) {
               authorized = true;
               break;
           }
       }
       if (authorized) {
          Object result = proceedingJoinPoint.proceed();
          return result;
       }
       throw new RuntimeException("You are not authorized to access this resource");

    }
}
