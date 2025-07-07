package com.labs.sboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootTest
class SbootRestLabsApplicationTests {
	@Autowired
	ApplicationContext ctx;

	@Test
	void contextLoads() {
		log.info("Total Beans: {}", ctx.getBeanDefinitionCount());
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(log::info);
	}

}
