package com.staylog.staylog.global.event;

import lombok.*;

/**
 * 댓글 작성 이벤트 객체
 * @author 이준혁
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreatedEvent {
    long commentId; // 댓글 PK
    long userId; // 댓글 작성자 PK
    long boardId; // 댓글이 작성된 원글 PK
}
