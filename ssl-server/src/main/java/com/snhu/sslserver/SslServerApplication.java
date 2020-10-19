package com.snhu.sslserver;

import java.security.MessageDigest;
import java.util.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}
	@GetMapping("/hash")
	public String myHash() throws Exception {
		String data = "Cinnamon George - Atermis Financial";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(data.getBytes());
		byte[] hash = md.digest();
		// byte[] to base64 string
        String s = Base64.getEncoder().encodeToString(hash);
		return "<p>data:"+data + "<p/> <p>Name of Ciper Algorithm Used: SHA-256 CheckSum Value:" + s+ "<p/>";
	}


}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";
