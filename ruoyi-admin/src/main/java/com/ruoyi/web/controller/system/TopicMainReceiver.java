package com.ruoyi.web.controller.system;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liangliang
 * @description 订单提醒消息监听类
 * @date 2021/10/11 15:46
 */
@Slf4j
@Component
@RabbitListener(queues = "topic.order")
public class TopicMainReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
        log.info(testMessage.toString());
        radio(testMessage.get("messageData").toString());
    }

    /**
     * 根据传入的文字朗读出来
     * @param message 语音参数
     */
    public void radio(String message) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        try {
            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(-2));
            // 获取执行对象
            Dispatch sapo = sap.getObject();
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(message));
            // 关闭执行对象
            sapo.safeRelease();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭应用程序连接
            sap.safeRelease();
        }
    }
}
