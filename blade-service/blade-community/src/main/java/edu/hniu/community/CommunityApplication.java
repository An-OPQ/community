package edu.hniu.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.launch.BladeApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author jerry
 */
@MapperScan("edu.hniu.community.dao")
@SpringBootApplication
public class CommunityApplication {

    public static void main(String[] args) {
		BladeApplication.run("blade-community",CommunityApplication.class, args);
    }

}
