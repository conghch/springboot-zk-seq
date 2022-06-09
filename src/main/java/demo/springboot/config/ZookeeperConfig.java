package demo.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studio.raptor.gid.Sequencer;

/**
 * @author ：conghc
 * @date ：Created On 2022/6/9
 * @description：${description}
 * @modified By：
 */
@Configuration
public class ZookeeperConfig {
    @Value("${zookeeper.address}")
    private  String address;

    @Value("${zookeeper.namespace}")
    private  String namespace;

    @Value("${zookeeper.namespace}")
    private  String sysId;

    private static Sequencer sequencer = null;

    @Bean(name = "sequencer")
    public Sequencer sequencer() throws Exception{
        if(sequencer == null) {
            sequencer = new Sequencer(address, namespace, null, sysId);
        }
        if (!sequencer.isStarted()) {
            sequencer.startup();
        }
        return sequencer;
    }
}
