package org.springblade.easypoi;

import org.springblade.core.launch.BladeApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本项目主要是EasyPoi的练习
 * @author jerry
 */
@SpringBootApplication
public class BladeEasyPoiApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-EasyPoi",BladeEasyPoiApplication.class,args);
	}

}
