package edu.hniu.community;

import edu.hniu.community.domain.UserInfo;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.launch.BladeApplication;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.secure.registry.SecureRegistry;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


