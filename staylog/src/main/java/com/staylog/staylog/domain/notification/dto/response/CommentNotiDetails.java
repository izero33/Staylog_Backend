package com.staylog.staylog.domain.notification.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Details 필드에 매핑될 댓글 타입 Dto
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentNotiDetails {
    private String imageUrl;
    private String authorName;
    private String message;
    private String typeName;
}
