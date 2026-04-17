package dwsc.eureka.client.sentence.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import dwsc.eureka.client.sentence.feign.service.SentenceService;

@RestController
public class SentenceController {

	@Autowired
	SentenceService sentenceService;

	@GetMapping("/sentence")
	public String getSentence() {
		return sentenceService.buildSentence();
	}
}
