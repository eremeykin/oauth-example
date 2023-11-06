package pete.eremeykin.service.api.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "api.client.url", matchIfMissing = false)
@EnableFeignClients(basePackageClasses = ApiClient.class)
class FeignClientAutoConfiguration {
}
