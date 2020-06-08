package org.grasswort.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * @author xuliangliang
 * @Classname Percentage.java
 * @Description 百分比
 * @Date 2020/6/8
 * @blame Java Team
 */
public class Percentage {
    /**
     * 获取百分比
     * @param numerator
     * @param denominator
     * @return
     */
    public static Optional<String> toPercentage(BigDecimal numerator, BigDecimal denominator) {
        if (denominator != null && denominator.intValue() > 0) {
            return Optional.of(Optional.ofNullable(numerator).orElse(new BigDecimal(0))
                    .multiply(new BigDecimal(100))
                    .divide(denominator, 2, RoundingMode.HALF_UP)
                    .toPlainString().concat("%"));
        }
        return Optional.ofNullable(null);
    }

    /**
     * 获取增长百分比
     * @param value1
     * @param value2
     * @return
     */
    public static Optional<String> toIncreasedPercentage(BigDecimal value1, BigDecimal value2) {
        if (value2 != null && value2.intValue() > 0) {
            return Optional.of(Optional.ofNullable(value1).orElse(new BigDecimal(0))
                    .subtract(value2)
                    .multiply(new BigDecimal(100))
                    .divide(value2, 2, RoundingMode.HALF_UP)
                    .toPlainString().concat("%"));
        }
        return Optional.ofNullable(null);
    }
}
