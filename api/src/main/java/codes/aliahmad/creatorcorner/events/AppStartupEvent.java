package codes.aliahmad.creatorcorner.events;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>
{

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event)
  {
    System.out.println("Application started");
    System.out.println("Application ready event fired");
  }
}
