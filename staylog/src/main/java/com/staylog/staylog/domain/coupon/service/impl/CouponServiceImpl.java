package com.staylog.staylog.domain.coupon.service.impl;

import com.staylog.staylog.domain.coupon.dto.request.CouponRequest;
import com.staylog.staylog.domain.coupon.dto.response.CouponResponse;
import com.staylog.staylog.domain.coupon.mapper.CouponMapper;
import com.staylog.staylog.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponServiceImpl implements CouponService {

    private final CouponMapper couponMapper;

    /**
     * 특정 유저의 모든 쿠폰 조회
     * @param userId 유저 PK
     * @return CouponResponse[] 쿠폰 목록
     * @author 이준혁
     */
    @Override
    public CouponResponse[] getByUserId(long userId) {

        return new CouponResponse[0];
    }

    /**
     * 쿠폰 추가
     * @param couponRequest (userId, couponType)
     * @return 성공 시 1, 실패 시 0 반환
     * @author 이준혁
     */
    @Override
    public void saveCoupon(CouponRequest couponRequest) {

    }

    /**
     * 쿠폰 사용 처리
     * @param couponId 쿠폰 PK
     * @return 성공 시 1, 실패 시 0 반환
     * @author 이준혁
     */
    @Override
    public void useCoupon(long couponId) {

    }

    /**
     * 쿠폰 삭제
     * @param couponId 쿠폰 PK
     * @return 성공 시 1, 실패 시 0 반환
     * @author 이준혁
     */
    @Override
    public void deleteCoupon(long couponId) {

    }
}
