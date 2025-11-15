package com.staylog.staylog.domain.booking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 예약 상세 응답 DTO
 * MyBatis resultMap 매핑을 위해 @Setter 포함
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailResponse {

    private Long bookingId;
    private String bookingNum;      // 주문번호 (orderId for Toss)
    private Long userId;
    private Long roomId;
    private String roomName;
    private String accommodationName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Long amount;
    private Long finalAmount;
    private String status;          // ReservationStatus code (RES_PENDING, RES_CONFIRMED, etc.)
    private String guestName;

    // 인원 정보
    private Integer adults;
    private Integer children;
    private Integer infants;
    private Integer totalGuestCount;

    // 타임스탬프
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;  // 만료 시각 (생성 후 5분)

    // 결제 정보 (있는 경우)
    private Long paymentId;
    private String paymentStatus;

    // 리뷰 작성 여부
    private String isWrited;         // 'Y' or 'N'
}
