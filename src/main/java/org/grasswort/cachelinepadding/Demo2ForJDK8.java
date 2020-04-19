package org.grasswort.cachelinepadding;

import sun.misc.Contended;

/**
 * @author xuliangliang
 * @Classname Demo2.java
 * @Description
 * @Date 2020/4/19
 * @blame Java Team
 */
public class Demo2ForJDK8 {
    /**
     * 注：配置 -XX:-RestrictContended 使用
     * x 和 y 将会被分配到不同的 cache line 避免伪共享
     */
    @Contended
    private long x;
    @Contended
    private long y;
}
