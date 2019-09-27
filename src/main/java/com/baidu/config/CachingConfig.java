package com.baidu.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import net.sf.ehcache.CacheManager;

/**
 * 缓存配置类
 */
@Configuration		//声明配置类
@EnableCaching		//启用spring的注释驱动缓存管理功能
public class CachingConfig {
//	/**
//	 * 此方法创建一个EhCacheCacheManager的实例
//	 * 这里是通过传入net.sf.ehcache.CacheManager实例实现的
//	 * 这里可能会让人感到迷惑,这是因为Spring和EhCache都定义了CacheManager类型
//	 * 需要明确的是EhCache的CacheManager要被注入到Spring的EhCacheCacheManager(Spring CacheManager的实现)之中
//	 * @return
//	 */
//	@Bean
//	public EhCacheCacheManager ehCacheCacheManager(CacheManager cacheManager) {
//		return new EhCacheCacheManager();
//	}
//	
//	/**
//	 * 我们需要使用EhCache的CacheManager来进行注入,所以必须也要声明一个CacheManager bean
//	 * 为了进行简化,Spring提供了EhCacheManagerFactoryBean来生成EhCache的CacheManager
//	 * @return
//	 */
//	@Bean
//	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//		//ehCache配置文件
//		factoryBean.setConfigLocation(new ClassPathResource("ehCache.xml"));
//		return factoryBean;
//	}
	
//	@Bean
//	public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
//		
//	}
	
	
}
