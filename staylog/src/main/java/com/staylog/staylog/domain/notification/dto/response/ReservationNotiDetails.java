package com.staylog.staylog.domain.notification.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Details 필드에 매핑될 예약 타입 Dto
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationNotiDetails {
    private String imageUrl;
    private String checkIn;
    private String checkOut;
    private String accommodationName;
    private String message;
    private String typeName;
}
