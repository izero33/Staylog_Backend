package com.staylog.staylog.domain.coupon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("couponRequest")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {
    private long couponId;
    private long userId;
    private String couponType;
}
