package com.microservices.lab3client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("SUBJECT") + " " + getWord("VERB") + " " + getWord("ARTICLE") + " "
				+ getWord("ADJECTIVE") + " " + getWord("NOUN") + ".";
	}

	public String getWord(String service) {
		return template.getForObject("http://" + service, String.class);
	}
}
