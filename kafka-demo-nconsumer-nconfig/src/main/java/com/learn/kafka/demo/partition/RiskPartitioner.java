package com.learn.kafka.demo.partition;

/**
 * @author Cool
 * @create 2020-09-28 12:23
 */

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName: RiskPartitioner
 * @author DHing
 *
 */

public class RiskPartitioner implements Partitioner {

    private Logger LOG =  LoggerFactory.getLogger(getClass());

	    /* (非 Javadoc)
	    *
	    *
	    * @param topic
	    * @param key
	    * @param keyBytes
	    * @param value
	    * @param valueBytes
	    * @param cluster
	    * @return
	    * @see org.apache.kafka.clients.producer.Partitioner#partition(java.lang.String, java.lang.Object, byte[], java.lang.Object, byte[], org.apache.kafka.common.Cluster)
	    *这个方法就决定了消息往哪个分区里面发送
              这个方法的返回值就是表示我们的数据要去哪个分区，如果返回值是0，表示我们的数据去0分区
	    */

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        LOG .info("Collecting Kafka data:[ topic : {} ], [ value : {} ] " , topic, value);
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int num = partitions.size();
        int partNum = 0;
        try {
            //  partNum = Integer.parseInt((String) key);
            partNum = new Random().nextInt(255);
        } catch (Exception e) {
            partNum = key.hashCode();
        }
        return Math.abs(partNum % num);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}

