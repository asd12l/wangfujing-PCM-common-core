/**
 * @Probject Name: common-core
 * @Path: com.wangfj.core.utilsJedisClusterFactory.java
 * @Create By kong
 * @Create In 2015年10月20日 下午1:04:13
 *
 */
package com.wangfj.core.utils;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {

	private String address;

	private JedisCluster jedisCluster;
	private Integer timeout;
	private Integer maxRedirections;
	private GenericObjectPoolConfig genericObjectPoolConfig;
	
	private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

	@Override
	public JedisCluster getObject() throws Exception {
		return jedisCluster;
	}

	@Override
	public Class<? extends JedisCluster> getObjectType() {
		return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}



	private Set<HostAndPort> parseHostAndPort() throws Exception {
		try {
			String[] addressArr=address.trim().split(",");
			Set<HostAndPort> haps = new HashSet<HostAndPort>();
			for(String addressStr:addressArr){
				String[] ipAndPort = addressStr.trim().split(":");
				HostAndPort hap =null;
				if(ipAndPort.length>2&&ipAndPort[2]!=""){
				  hap = new HostAndPort(ipAndPort[0].trim(), Integer.parseInt(ipAndPort[1].trim()),ipAndPort[2].trim());
				}else{
				  hap = new HostAndPort(ipAndPort[0].trim(), Integer.parseInt(ipAndPort[1].trim()));
				}
				haps.add(hap);
			}
			
			return haps;
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new Exception("解析 jedis 配置文件失败", ex);
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Set<HostAndPort> haps = this.parseHostAndPort();
		
		jedisCluster = new JedisCluster(haps, timeout, maxRedirections,genericObjectPoolConfig);
		
		
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setMaxRedirections(int maxRedirections) {
		this.maxRedirections = maxRedirections;
	}



	/**
	 * @Param String address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
		this.genericObjectPoolConfig = genericObjectPoolConfig;
	}

}