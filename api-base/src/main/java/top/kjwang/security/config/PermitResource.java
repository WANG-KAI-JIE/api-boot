package top.kjwang.security.config;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author kjwang
 * @date 2023/4/23 22:12
 * @description PermitResource
 *
 * SpringSecurity默认是对全部的路径进行拦截，没有权限是不能访问的
 * 我们可以通过HttpSecurity配置，指定放行的路径
 */

@Component
public class PermitResource {

    /**
     * 指定被 spring security 忽略的URL
     */
    @SneakyThrows
    public List<String> getPermitList() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:auth.yml");
        String key = "auth.ignore_urls";

        return getPropertiesList(key, resources);
    }

    private List<String> getPropertiesList(String key, Resource... resources) {
        List<String> list = new ArrayList<>();

        // 解析资源文件
        for (Resource resource : resources) {
            Properties properties = loadYamlProperties(resource);

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String tmpKey = StringUtils.substringBefore(entry.getKey().toString(), "[");
                if (tmpKey.equalsIgnoreCase(key)) {
                    list.add(entry.getValue().toString());
                }
            }
        }
        return list;
    }

    private Properties loadYamlProperties(Resource... resources) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resources);
        factory.afterPropertiesSet();

        return factory.getObject();
    }
}
