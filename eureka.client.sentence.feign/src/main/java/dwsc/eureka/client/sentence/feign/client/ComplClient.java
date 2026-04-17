package dwsc.eureka.client.sentence.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("EUREKA.CLIENT.COMPL")
public interface ComplClient {
	@GetMapping("/")
	public String getWord();
}
