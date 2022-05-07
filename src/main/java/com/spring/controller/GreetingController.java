package com.spring.controller;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.spring.dao.Greeting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class GreetingController {

    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
 
	@GetMapping("/greeting/{id}") 
	public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name, @PathVariable(value="id") Optional<Long> id) {

		return ResponseEntity.ok().header("sender", "bhavuk").body(
			new Greeting(counter.incrementAndGet(), String.format(template, name) + "id: "+ id.orElse(345l)));
	}

	@GetMapping("/listHeaders")
public ResponseEntity<String> listAllHeaders(
  @RequestHeader Map<String, String> headers, @RequestBody Optional<Greeting> greeting ) {
	  System.out.println(greeting.orElse(new Greeting(1, "Fuck htis")));
    headers.forEach((key, value) -> {
        System.out.println(String.format("Header '%s' = %s", key, value));
    });

    return new ResponseEntity<String>(
      String.format("Listed %d headers", headers.size()), HttpStatus.OK);
}
    
}
