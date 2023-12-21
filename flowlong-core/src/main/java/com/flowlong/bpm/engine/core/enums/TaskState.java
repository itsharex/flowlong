/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package com.flowlong.bpm.engine.core.enums;

import java.util.Arrays;

/**
 * 流程状态
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author 江涛
 * @since 1.0
 */
public enum TaskState {
    /**
     * 活动
     */
    active(0),
    /**
     * 完成
     */
    complete(1),
    /**
     * 拒绝
     */
    reject(2),
    /**
     * 超时
     */
    timeout(3),
    /**
     * 终止
     */
    termination(4),
    /**
     * 跳转
     */
    jump(5);

    private final int value;

    TaskState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TaskState get(int value) {
        return Arrays.stream(TaskState.values()).filter(s -> s.getValue() == value).findFirst().orElseGet(null);
    }

    public static TaskState of(InstanceState instanceState) {
        if (instanceState == InstanceState.reject) {
            return reject;
        }
        if (instanceState == InstanceState.timeout) {
            return timeout;
        }
        return complete;
    }
}
