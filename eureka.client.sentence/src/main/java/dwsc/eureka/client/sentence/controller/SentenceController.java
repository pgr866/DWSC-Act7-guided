package dwsc.eureka.client.sentence.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SentenceController {
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/services/{serviceId}")
	public List<ServiceInstance> lookup(@PathVariable String serviceId) {
		List<ServiceInstance> list = discoveryClient.getInstances(serviceId);
		if (list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found");
		} else {
			return list;
		}
	}

	@GetMapping("/sentence")
	public String getSentence() {
		return getWord("EUREKA.CLIENT.SUBJECT") + " " + getWord("EUREKA.CLIENT.VERB") + " "
				+ getWord("EUREKA.CLIENT.COMPL");
	}

	private String getWord(String serviceId) {
		List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceId);
		if (!serviceList.isEmpty()) {
			URI uri = serviceList.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}
}
