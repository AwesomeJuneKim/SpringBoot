package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoggingRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		log.trace("TRACE log message");
		log.debug("DEBUG log message");
		log.info("INFO log message");
		log.warn("WARN log message");
		log.error("ERROR log message");

	}

}
