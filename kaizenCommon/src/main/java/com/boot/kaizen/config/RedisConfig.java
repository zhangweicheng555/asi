package com.boot.kaizen.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

/**
 * 缓存配置-使用Lettuce客户端，手动注入配置的方式
 */
//@Configuration
//@EnableConfigurationProperties(RedisProperties.class) // 指明配置节点
public class RedisConfig {

	private final RedisProperties redisProperties;

	//@Autowired
	public RedisConfig(RedisProperties redisProperties) {
		this.redisProperties = redisProperties;
	}

	//@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		return getLettuceConnectionFactory(redisProperties.getDb());
	}

	/**
	 * redisTemplate配置
	 */
	//@Bean("redisTemplate")
	//@Primary
	public RedisTemplate<String, Object> redisTemplate() {

		// 设置序列化
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		om.enableDefaultTyping(DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		// 配置redisTemplate
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		RedisSerializer<?> stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);// key序列化
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);// value序列化
		redisTemplate.setHashKeySerializer(stringSerializer);// Hash key序列化
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);// Hash value序列化
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	/**
	 * LettuceConnectionFactory 配置
	 *
	 * @return LettuceConnectionFactory
	 */
	private LettuceConnectionFactory getLettuceConnectionFactory(Integer db) {
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(sentinelConfig(),
				getLettucePoolingClientConfiguration());
		lettuceConnectionFactory.setDatabase(db);
		return lettuceConnectionFactory;
	}

	/**
	 * lettuce 连接池配置
	 *
	 * @return LettucePoolingClientConfiguration
	 */
	private LettucePoolingClientConfiguration getLettucePoolingClientConfiguration() {
		LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration
				.builder();
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setMaxIdle(redisProperties.getMaxTotal());
		genericObjectPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
		genericObjectPoolConfig.setMinIdle(redisProperties.getMinIdle());
		genericObjectPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
		genericObjectPoolConfig.setTestOnBorrow(redisProperties.getTestOnBorrow());
		builder.poolConfig(genericObjectPoolConfig);
		builder.commandTimeout(Duration.ofSeconds(60));
		builder.shutdownTimeout(Duration.ofMillis(100));
		return builder.build();
	}

	private RedisSentinelConfiguration sentinelConfig() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();
		sentinelConfig.setMaster(redisProperties.getSentinelMaster());
		String[] sentinels = redisProperties.getSentinelNodes().split("\\|");
		List<RedisNode> list = new ArrayList<>();
		for (String sentinel : sentinels) {
			String[] nodes = sentinel.split(":");
			list.add(new RedisNode(nodes[0], Integer.parseInt(nodes[1])));
		}
		sentinelConfig.setSentinels(list);
		// sentinelConfig.setPassword(RedisPassword.of(redisProperties.getSentinelPassword()));
		return sentinelConfig;
	}

}
