package laurSpilca.tuto.nacer.resources.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hi, it's the redcources Server here....";
	}
}
