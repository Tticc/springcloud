package com.wenc.springcloud.rocketmq.springboot.service.producer;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;

import java.util.concurrent.ConcurrentHashMap;

@RocketMQTransactionListener
public class MyTransactionalImpl implements RocketMQLocalTransactionListener {

    private ConcurrentHashMap<Object, Message> localTrans = new ConcurrentHashMap();

    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        Object transId = msg.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TRANSACTION_ID);
        String destination = arg.toString();
        localTrans.put(transId,msg);
        System.out.println("trans with message:"+msg);

        String tags = msg.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TAGS).toString();
        if(tags.contains("TagC")){
            return RocketMQLocalTransactionState.COMMIT;
        }else if(tags.contains("TagD")){
            return RocketMQLocalTransactionState.ROLLBACK;
        }else {
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }

    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        Object transId = msg.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TRANSACTION_ID);
        Message message = localTrans.get(transId);
        System.out.println("check transaction msg:"+message);
        String tags = msg.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TAGS).toString();

        if(tags.contains("TagA")){
            return RocketMQLocalTransactionState.COMMIT;
        }else if(tags.contains("TagB")){
            return RocketMQLocalTransactionState.ROLLBACK;
        }else {
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }
}
