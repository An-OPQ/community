package org.springblade.blog;

import org.junit.jupiter.api.Test;
import org.springblade.core.test.BladeBootTest;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * enableLoader = true 开启 launcherService 启动器
 */
@SpringBootTest(classes = BladeBlogApplication.class)
@BladeBootTest(appName = "blade-blog",enableLoader = true)
class BladeBlogApplicationTests {

	@Test
	void contextLoads() {
	}

}


