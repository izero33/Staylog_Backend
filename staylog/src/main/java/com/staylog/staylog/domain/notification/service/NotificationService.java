package com.staylog.staylog.domain.notification.service;

import com.staylog.staylog.domain.notification.dto.request.NotificationRequest;
import com.staylog.staylog.domain.notification.dto.request.ReadAllRequest;
import com.staylog.staylog.domain.notification.dto.request.ReadRequest;
import com.staylog.staylog.domain.notification.dto.response.DetailsResponse;
import com.staylog.staylog.domain.notification.dto.response.NotificationResponse;
import com.staylog.staylog.global.event.CommentCreatedEvent;
import com.staylog.staylog.global.event.SignupEvent;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

public interface NotificationService {


    /**
     * 회원가입 이벤트리스너 메서드
     * @param event 이벤트 객체
     * @author 이준혁
     */
    public void handleSignupEvent(SignupEvent event);

    /**
     * 댓글 작성 이벤트리스너 메서드
     * @author 이준혁
     * @param event 이벤트 객체
     */
    public void handleCommentCreatedEvent(CommentCreatedEvent event);


    /**
     * 알림 데이터 저장 및 푸시
     * @author 이준혁
     * @param notificationRequest 알림 정보
     */
    public void saveAndPushNotification(NotificationRequest notificationRequest, DetailsResponse detailsResponse);


    /**
     * 유저 한명의 알림 리스트 조회
     * @author 이준혁
     * @param userId 유저 PK
     * @return List<NotificationResponse>
     */
    public List<NotificationResponse> getNotificationList(long userId);


    /**
     * 알림 삭제
     * @author 이준혁
     * @param notiId 알림 PK
     */
    public void deleteNotification(long notiId);


    /**
     * 단일 알림 읽음 처리
     * @author 이준혁
     * @param readRequest 알림 PK
     */
    public void readOne(ReadRequest readRequest);

    /**
     * 모든 알림 읽음 처리
     * @author 이준혁
     * @param readAllRequest 유저 PK
     */
    public void readAll(ReadAllRequest readAllRequest);

    /**
     * 안읽은 알림 수 조회
     * @param userId 사용자 PK
     * @return 안읽은 알림 수
     */
    public int unreadCount(long userId);
}
