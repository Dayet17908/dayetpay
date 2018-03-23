package com.sevenpay.bms.common.util;

import org.gyzb.platform.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Qualifier;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.sevenpay.plugin.IPlugin;

public final class RedisUtil {
    
	@Qualifier("pluginInvokerProxy")
	private static IPlugin iPlugin = (IPlugin)SpringUtils.getBean("pluginInvokerProxy");
	
    //Redis服务器IP（测试环境）
    private static String ADDR_TEST = "192.168.1.19";
    
    //Redis的端口号（测试环境）
    private static int PORT_TEST = 6379;
    
    //Redis服务器IP（生产环境）
    private static String ADDR_PROD = "172.18.2.17";
    
    //Redis的端口号（生产环境）
    private static int PORT_PROD = 6379;
    
    //访问密码（测试）
    private static String AUTH_TEST = "pass123";
    
    //访问密码（生产）
    private static String AUTH_PROD = "";
    
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    /**
     * 初始化Redis连接池
     */
    static {
        try {
        	JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            
            String testFlag = iPlugin.findDictByPath("IS_TEST");
        	if("1".equals(testFlag)){
        		if(null==AUTH_TEST || "".equals(AUTH_TEST)){
        			jedisPool = new JedisPool(config, ADDR_TEST, PORT_TEST,TIMEOUT);
        		}else{
        			jedisPool = new JedisPool(config, ADDR_TEST, PORT_TEST,TIMEOUT,AUTH_TEST);	
        		}
        		 
        	}else{
        		if(null==AUTH_PROD || "".equals(AUTH_PROD)){
        			jedisPool = new JedisPool(config, ADDR_PROD, PORT_PROD, TIMEOUT);
        		}else{
        			jedisPool = new JedisPool(config, ADDR_PROD, PORT_PROD, TIMEOUT,AUTH_PROD);	
        		}
        		 
        	}
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public final static int RED_ENVELOPE_ROB_DB = 0;
    public final static int RED_ENVELOPE_INFO_DB = 1;
    public final static int OFFLINE_MSG_READ_LOCK_DB = 2;
    public final static int  CACHE_MSG_QUEEN_DB=3;
    public final static int MERCHANT_CASHIER_REF_DB = 4;
    public final static int MERCHANT_DB = 5;
    
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}