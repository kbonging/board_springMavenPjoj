-- set sql_safe_updates=0;  

### 게시글 테이블 ###
CREATE TABLE board (
    board_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유번호',
    title VARCHAR(200) NOT NULL COMMENT '게시글 제목',
    content TEXT NOT NULL COMMENT '게시글 내용',
    writer BIGINT NOT NULL COMMENT '작성자 회원 번호',
    view_cnt INT NOT NULL DEFAULT 0 COMMENT '조회수',
    delete_yn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부(Y: 삭제, N: 정상)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
) COMMENT = '게시판';

ALTER TABLE board
ADD CONSTRAINT fk_board_member
FOREIGN KEY (writer)
REFERENCES member(member_id);

### 회원 테이블 ###
CREATE TABLE member (
    member_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '회원 고유번호',
    login_id VARCHAR(50) NOT NULL UNIQUE COMMENT '로그인 아이디',
    password VARCHAR(255) NOT NULL COMMENT '비밀번호',
    name VARCHAR(50) NOT NULL COMMENT '회원 이름',
    role VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER' COMMENT '회원 권한',
    delete_yn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부(Y: 삭제, N: 정상)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
) COMMENT='회원';

## 첨부파일 테이블 ##
CREATE TABLE attachment (
    file_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '파일 고유번호',
    board_id BIGINT NOT NULL COMMENT '게시글 번호',
    origin_name VARCHAR(255) NOT NULL COMMENT '원본 파일명',
    saved_name VARCHAR(255) NOT NULL COMMENT '저장 파일명',
    file_path VARCHAR(500) NOT NULL COMMENT '저장 경로',
    file_size BIGINT NOT NULL COMMENT '파일 크기(Byte)',
    delete_yn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부(Y: 삭제, N: 정상)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
    CONSTRAINT fk_attachment_board FOREIGN KEY (board_id) REFERENCES board(board_id)
) COMMENT='첨부파일';