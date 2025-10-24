package com.staylog.staylog.domain.user.mapper;

import com.staylog.staylog.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * User 도메인 MyBatis Mapper 인터페이스
 * 사용자 정보에 대한 데이터베이스 접근을 담당
 */
@Mapper
public interface UserMapper {

    /**
     * loginId로 사용자 조회 (로그인 시 사용)
     * @param loginId 로그인 ID
     * @return 사용자 정보 (없으면 null)
     */
    UserDto findByLoginId(@Param("loginId") String loginId);

    /**
     * userId로 사용자 조회
     * @param userId 사용자 ID
     * @return 사용자 정보 (Optional)
     */
    Optional<UserDto> findByUserId(@Param("userId") Long userId);

    /**
     * email로 사용자 조회 (중복 확인, 비밀번호 찾기 등에 사용)
     * @param email 이메일 주소
     * @return 사용자 정보 (Optional)
     */
    Optional<UserDto> findByEmail(@Param("email") String email);

    /**
     * 사용자 정보 저장 (회원가입)
     * @param user 저장할 사용자 정보
     * @return 저장된 행 수
     */
    int save(UserDto user);

    /**
     * 사용자 정보 업데이트 (프로필 수정)
     * @param user 업데이트할 사용자 정보
     * @return 업데이트된 행 수
     */
    int update(UserDto user);

    /**
     * 마지막 로그인 시간 업데이트
     * @param userId 사용자 ID
     * @param lastLogin 마지막 로그인 시간
     * @return 업데이트된 행 수
     */
    int updateLastLogin(@Param("userId") Long userId, @Param("lastLogin") Timestamp lastLogin);

    /**
     * 사용자 상태 변경 (활성화/비활성화/탈퇴)
     * @param userId 사용자 ID
     * @param status 변경할 상태 (ACTIVE, INACTIVE, WITHDRAWN)
     * @return 업데이트된 행 수
     */
    int updateStatus(@Param("userId") Long userId, @Param("status") String status);

    /**
     * 비밀번호 업데이트
     * @param userId 사용자 ID
     * @param newPassword 새 비밀번호 (암호화된 상태)
     * @return 업데이트된 행 수
     */
    int updatePassword(@Param("userId") Long userId, @Param("newPassword") String newPassword);

    /**
     * 사용자 삭제 (물리적 삭제 - 관리자 전용)
     * @param userId 사용자 ID
     * @return 삭제된 행 수
     */
    int delete(@Param("userId") Long userId);

    /**
     * loginId 중복 확인
     * @param loginId 확인할 로그인 ID
     * @return 존재하면 true, 없으면 false
     */
    boolean existsByLoginId(@Param("loginId") String loginId);

    /**
     * email 중복 확인
     * @param email 확인할 이메일
     * @return 존재하면 true, 없으면 false
     */
    boolean existsByEmail(@Param("email") String email);

    /**
     * 전체 사용자 수 조회
     * @return 전체 사용자 수
     */
    int countAll();

    /**
     * 특정 상태의 사용자 수 조회
     * @param status 사용자 상태
     * @return 해당 상태의 사용자 수
     */
    int countByStatus(@Param("status") String status);
}
