package com.aladdin.common.core.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 雪花算法分布式ID生成器
 *
 * @author cles
 * @date 2026/05/06
 */
public class IdUtil {

    private static final long START_TIMESTAMP = 1704067200000L;
    private static final long SEQUENCE_BITS = 12L;
    private static final long WORKER_ID_BITS = 5L;
    private static final long DATACENTER_ID_BITS = 5L;
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    private static long workerId = 1L;
    private static long datacenterId = 1L;
    private static final AtomicLong sequence = new AtomicLong(0L);
    private static long lastTimestamp = -1L;

    private IdUtil() {
    }

    public static synchronized long nextId() {
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("时钟回拨，拒绝生成ID");
        }
        if (currentTimestamp == lastTimestamp) {
            long seq = sequence.incrementAndGet() & MAX_SEQUENCE;
            if (seq == 0) {
                currentTimestamp = waitNextMillis(lastTimestamp);
            }
        } else {
            sequence.set(0L);
        }
        lastTimestamp = currentTimestamp;
        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_SHIFT)
                | (datacenterId << DATACENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | (sequence.get() & MAX_SEQUENCE);
    }

    public static String nextIdStr() {
        return String.valueOf(nextId());
    }

    public static void initWorker(long wid, long did) {
        if (wid > MAX_WORKER_ID || wid < 0) {
            throw new IllegalArgumentException("workerId超出范围");
        }
        if (did > MAX_DATACENTER_ID || did < 0) {
            throw new IllegalArgumentException("datacenterId超出范围");
        }
        workerId = wid;
        datacenterId = did;
    }

    private static long waitNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
