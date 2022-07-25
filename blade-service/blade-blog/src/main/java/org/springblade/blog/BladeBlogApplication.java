package org.springblade.blog;

import org.springblade.core.cloud.client.BladeCloudApplication;
import org.springblade.core.launch.BladeApplication;

@BladeCloudApplication
public class BladeBlogApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-blog", BladeBlogApplication.class, args);
	}

}
