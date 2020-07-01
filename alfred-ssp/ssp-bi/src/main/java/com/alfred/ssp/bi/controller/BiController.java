package com.alfred.ssp.bi.controller;

import com.alfred.ssp.bi.domain.InetDTO;
import com.alfred.ssp.bi.domain.SsoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/7/1 16:26
 * @Modified :
 **/
@RestController
@RequestMapping("statistic")
public class BiController {

    @Autowired
    private SsoDO ssoDO;

    @GetMapping("ip/address")
    public InetDTO getIp(){
        System.out.println(ssoDO.getAppcode());
        InetDTO inetDTO = new InetDTO();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if(inetAddress != null && inetAddress instanceof Inet4Address){
                       inetDTO.setHostAddress(inetAddress.getHostAddress());
                        inetDTO.setHostName(inetAddress.getHostName());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return inetDTO;
    }

    @GetMapping("test")
    public String getTest(){
        return "it is ok!";
    }
}
