package codes.aliahmad.creatorcorner;

import codes.aliahmad.creatorcorner.user.service.SessionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CreatorCornerApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(CreatorCornerApplication.class, args);
  }

  @Component
  class Runner implements CommandLineRunner
  {
    private final SessionService sessionService;

    public Runner(SessionService sessionServiceImpl)
    {
      this.sessionService = sessionServiceImpl;
    }

    @Override
    public void run(String... args)
    {
      System.out.println("It works");

//      sessionService.saveSession(new Session("toekn", "aliahmad@gmail.com", LocalDateTime.now(),
//              true, ERole.USER));
//
//      Session session = sessionService.getSession("toekn");
//      System.out.println(session.token());

    }
  }


}
