package codes.aliahmad.creatorcorner;

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
    @Override
    public void run(String... args) throws Exception
    {
      System.out.println("It works");
    }
  }


}
