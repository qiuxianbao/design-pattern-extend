package cn.thinkinjava.design.pattern.extend.spi;

import cn.thinkinjava.design.pattern.extend.spi.service.RemoteService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPI的方式加载
 *
 * 说明：
 * 1.resource文件夹下建 META-INF/services文件夹
 * 2.创建一个文件，文件名为接口的全限定名，文件内容为接口实现类的全限定名
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class SpiServiceLoaderHelper {

    public static RemoteService getProductPackageRemoteServiceInterface() {
        Object serviceCache = DependServiceRegistryHelper.getDependObject(RemoteService.class);
        if (serviceCache != null) {
            return (RemoteService) serviceCache;
        }
        RemoteService serviceInterface = loadSpiImpl(RemoteService.class);
        DependServiceRegistryHelper.registry(RemoteService.class, serviceInterface);
        return serviceInterface;
    }

    /**
     * 以spi的方式加载实现类
     *
     * @param cls
     * @return
     */
    private static <P> P loadSpiImpl(Class<P> cls) {
        ServiceLoader<P> spiLoader = ServiceLoader.load(cls);
        Iterator<P> iterator = spiLoader.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }

        throw new RuntimeException("SpiServiceLoaderHelper loadSpiImpl failed, please check spi service");
    }

}

