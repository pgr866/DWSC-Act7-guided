package dwsc.eureka.client.sentence.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("EUREKA.CLIENT.SUBJECT")
public interface SubjectClient {
	@GetMapping("/")
	public String getWord();
}
