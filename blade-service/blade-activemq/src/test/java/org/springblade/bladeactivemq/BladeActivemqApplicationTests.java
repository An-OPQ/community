package org.springblade.bladeactivemq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springblade.core.test.BladeBootTest;
import org.springblade.core.test.BladeSpringExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(BladeSpringExtension.class)
@SpringBootTest(classes = BladeActivemqApplication.class)
@BladeBootTest(appName = "blade-activemq", profile = "test", enableLoader = true)
class BladeActivemqApplicationTests {

	@Test
	void contextLoads() {
	}

}
