import org.apache.shardingsphere.sharding.algorithm.keygen.LongWorkerIdSnowflakeKeyGenerateAlgorithm;

import java.util.Properties;

public class TestKeyGen {
    public  static void main(String[] args) {
        LongWorkerIdSnowflakeKeyGenerateAlgorithm keyGenerateAlgorithm = new LongWorkerIdSnowflakeKeyGenerateAlgorithm();
        Properties props = new Properties();
        props.setProperty("worker-id", "10000");
        props.setProperty("max-vibration-offset", "3");
        keyGenerateAlgorithm.setProps(props);
        keyGenerateAlgorithm.init();
        String key;
        for (int i = 0; i < 10; i++) {
            key = keyGenerateAlgorithm.generateKey().toString();
            System.out.println("SnowFlake key: " + key);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
