package org.grasswort.cachelinepadding;

/**
 * @author xuliangliang
 * @Classname Demo1.java
 * @Description
 * @Date 2020/4/19
 * @blame Java Team
 */
public class Demo1BeforeJDK8 {
    /**
     * 通过在 cursor 前后各声明 8 个 long 类型的成员变量
     * 由于 Intel CPU 的 cpu cache line 大小为 64 个字节, 一个 long 类型 的占据 8 个字节， 8 个刚好就是 64 字节
     * 所以可以保证 cursor 单独处于一块 cache line 中。但是仅适合 Intel cpu ，对其他 cpu 不一定适用
     * 在 JDK 8 之后提供了 @Contended 注解 ，配合 JVM 参数，-XX:-RestrictContended 使用。将会使标注了注解的字段放入不同的 cache line
     *      */
    private long p1, p2, p3, p4, p5, p6, p7; // cache line padding
    private volatile long cursor = 0L;
    private long p9, p10, p11, p12, p13, p14, p15; // cache line padding
}
