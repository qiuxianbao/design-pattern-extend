package cn.thinkinjava.design.pattern.extend.spi.client;

import cn.thinkinjava.design.pattern.extend.spi.SpiServiceLoaderHelper;
import cn.thinkinjava.design.pattern.extend.spi.service.RemoteService;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class SPIClient {
    public static void main(String[] args) {
        RemoteService remoteService
                = SpiServiceLoaderHelper.getProductPackageRemoteServiceInterface();

        System.out.println(remoteService);
        // cn.thinkinjava.main.extend.spi.service.impl.ProductPackageRemoteServiceInterfaceImpl@2752f6e2
    }
}
