package org.springblade.auth.endpoint;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Configuration
@Endpoint(id = "deregister")
public class NacosServiceDeregisterEndpoint {

	private static final Logger log = LoggerFactory.getLogger(NacosServiceDeregisterEndpoint.class);

	private NacosAutoServiceRegistration serviceRegistration;


	@Lazy
	public NacosServiceDeregisterEndpoint(NacosAutoServiceRegistration serviceRegistration) {
		this.serviceRegistration = serviceRegistration;
	}

	@ReadOperation
	public Map<String, Object> deregister() {
		log.info("开始服务下线");
		serviceRegistration.stop();
		log.info("完成服务下线");
		int wait = 10;
		log.info("等待{}s,等待客户端刷新服务列表", wait);
		int num = 0;
		while (true) {
			try {
				//等待客户端刷新服务发现列表
				TimeUnit.SECONDS.sleep(1);
				num++;
				log.info("还需等待{}秒", wait - num);
				if (num >= wait) {
					break;
				}
			} catch (InterruptedException e) {
				log.info("InterruptedException", e);
			}
		}

		log.info("等待结束");
		Map<String, Object> result = new HashMap<>();
		result.put("deregister", true);
		return result;
	}

}
