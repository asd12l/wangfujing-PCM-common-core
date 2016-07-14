/**
 * @Probject Name: common-core
 * @Path: com.wangfj.core.handlerJaxWsserviceExporter.java
 * @Create By kong
 * @Create In 2016年1月13日 上午11:02:50
 *
 */
package com.wangfj.core.handler;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.springframework.remoting.jaxws.SimpleHttpServerJaxWsServiceExporter;

/**
 * @Comment
 * @Class Name JaxWsserviceExporter
 * @Author kong
 * @Create In 2016年1月13日
 */
public class JaxWsserviceExporter extends SimpleHttpServerJaxWsServiceExporter {
  private String hostname;

  public JaxWsserviceExporter() {
    // InetAddress addr = null;
    try {
      // addr = InetAddress.getLocalHost();
      // this.hostname = addr.getHostAddress().toString();// 获得本机IP
      this.hostname = getHostAddress();
      logger.info("webservice ip:" + hostname);
      super.setHostname(hostname);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取本机
   * 
   * @Methods Name getAddress
   * @Create In 2016年4月27日 By kongqf
   * @return InetAddress
   */
  private String getHostAddress() {
    try {
      InetAddress ip = null;
      for (Enumeration<NetworkInterface> interfaces = NetworkInterface
          .getNetworkInterfaces(); interfaces.hasMoreElements();) {
        NetworkInterface networkInterface = interfaces.nextElement();
        if (networkInterface.isLoopback() || networkInterface.isVirtual()
            || !networkInterface.isUp()) {
          continue;
        }
        Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
          ip = addresses.nextElement();
          if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
              && ip.getHostAddress().indexOf(":") == -1) {
            return ip.getHostAddress();
          }
        }
      }
    } catch (SocketException e) {
    }
    return null;
  }

}
