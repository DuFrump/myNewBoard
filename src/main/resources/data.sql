-- 사용자 데이터 추가
INSERT INTO users (email, password, name, role) VALUES ('test@test.com', 'password', 'Test User', 'USER');

-- 게시글 데이터 추가
INSERT INTO article (title, content, author_id) VALUES ('이것은 제목입니다.', '이것은 내용입니다.', 1);