package org.springblade.bladeactivemq;

import org.springblade.core.cloud.client.BladeCloudApplication;
import org.springblade.core.cloud.feign.EnableBladeFeign;
import org.springblade.core.launch.BladeApplication;

/**
 * @author admin
 */
@EnableBladeFeign
@BladeCloudApplication
public class BladeActivemqApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-activemq",BladeActivemqApplication.class,args);
	}

}
