package hive.skilltree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SkillTreeApplication {
  public static void main(String[] args) {
    SpringApplication.run(SkillTreeApplication.class, args);
  }
}
