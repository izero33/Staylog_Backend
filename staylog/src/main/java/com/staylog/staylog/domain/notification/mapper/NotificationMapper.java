package com.staylog.staylog.domain.notification.mapper;

import com.staylog.staylog.domain.notification.dto.request.NotificationRequest;
import com.staylog.staylog.domain.notification.dto.response.NotificationResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {

    /**
     * 알림 데이터 저장
     * @author 이준혁
     * @param notificationRequest 알림 정보
     * @return 성공 여부 1 또는 0
     */
    public int notiSave(NotificationRequest notificationRequest);

    /**
     * 유저 한명의 알림 리스트 조회
     * @author 이준혁
     * @param userId 유저 PK
     * @return NotificationResponse
     */
    public List<NotificationResponse> findNotificationsByUserId(long userId);
}
