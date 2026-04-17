package dwsc.eureka.client.sentence.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dwsc.eureka.client.sentence.feign.client.ComplClient;
import dwsc.eureka.client.sentence.feign.client.SubjectClient;
import dwsc.eureka.client.sentence.feign.client.VerbClient;

@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired
	SubjectClient subjectClient;
	@Autowired
	VerbClient verbClient;
	@Autowired
	ComplClient complClient;

	@Override
	public String buildSentence() {
		return subjectClient.getWord() + " " + verbClient.getWord() + " " + complClient.getWord() + ".";
	}
}
