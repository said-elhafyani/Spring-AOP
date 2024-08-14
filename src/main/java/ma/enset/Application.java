package ma.enset;

import ma.enset.aspect.LogAspect;
import ma.enset.service.Imetier;
import ma.enset.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(value = {"ma.enset.service","ma.enset.aspect"})
public class Application {
    public static void main(String[] args) {
        try {
            SecurityContext.authenticate("admin","admin",new String[]{"USER"});
            ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
            Imetier metier =  context.getBean(Imetier.class);
            System.out.println("--------------------------");
            System.out.println(metier.getClass().getName());
            System.out.println("--------------------------");
            metier.process();
            System.out.println(metier.compute());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
