package com.flowlong.bpm.solon.example.config;

import com.flowlong.bpm.engine.core.FlowLongContext;
import com.flowlong.bpm.engine.scheduling.TaskReminder;
import org.noear.solon.annotation.Component;

/**
 * 注入自定义任务提醒处理类
 * 注解 EnableScheduling 必须启动
 */
@Component
public class TestTaskReminder implements TaskReminder {

    @Override
    public void remind(FlowLongContext context, Long instanceId, Long currentTaskId) {
        System.out.println("测试提醒：" + instanceId);
    }
}
