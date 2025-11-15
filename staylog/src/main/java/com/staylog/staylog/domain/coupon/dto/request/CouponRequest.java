package com.staylog.staylog.domain.coupon.dto.request;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

/**
 * 쿠폰 발급에 사용하는 Dto
 * @author 이준혁
 */
@Alias("couponRequest")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequest {
    private long couponId;
    private long userId;
    private String name;
    private int discount;
    private LocalDate expiredAt;
}
