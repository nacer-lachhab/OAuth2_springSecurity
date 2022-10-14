package laurSpilca.tuto.nacer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityTokensOAuth2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SecurityTokensOAuth2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("started with success...");
	}

}
