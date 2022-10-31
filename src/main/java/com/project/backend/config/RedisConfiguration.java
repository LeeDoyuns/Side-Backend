package com.project.backend.config;

/*
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1500)*/
public class RedisConfiguration {
/*

    @Value("${spring.redis.host}")
    public String host;

    @Value("${spring.redis.port}")
    public int port;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        var redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //  redisTemplate.setValueSerializer(new StringRedisSerializer());    //<String,String> 의 경우에 사용.
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration();
        conf.setHostName(host);
        conf.setPort(port);
        //conf.setDatabase(); redis db 나눌때 사용.
        return new LettuceConnectionFactory(conf);
    }*/
}
