package org.springblade.easypoi;

import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.launch.BladeApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本项目主要是EasyPoi的练习
 */
@MapperScan("org.springblade.easypoi.dao")
@SpringBootApplication
public class BladeEasyPoiApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-community",BladeEasyPoiApplication.class,args);
	}

}
