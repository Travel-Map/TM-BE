INSERT INTO user (register_at, user_id, email, nickname, password)
VALUES ('2024-04-12', 1, 'audrhks123@gmail.com', '명관', 'password1'),
       ('2024-04-12', 2, 'alsdn123@gmail.com', '민우', 'password2'),
       ('2024-04-12', 3, 'fnek123@gmail.com', '루다', 'password3'),
       ('2024-04-12', 4, 'ghdjs123@gmail.com', '호언', 'password4'),
       ('2024-04-12', 5, 'dofjs123@gmail.com', '애런', 'password5');

INSERT INTO region (is_visited, region_id, name)
VALUES (true, 1, '서울시'),
       (true, 2, '제주도'),
       (true, 3, '경기도'),
       (false, 4, '경상남도'),
       (false, 5, '경상북도'),
       (false, 6, '전라남도'),
       (false, 7, '전라북도'),
       (false ,8, '강원도'),
       (false, 9, '충청남도'),
       (false, 10, '충청북도');

INSERT INTO post (write_at, post_id, region_id, user_id, content, title, travel_end, travel_spot, travel_start)
VALUES ('2024-04-12', 1, 1, 1, '종로를 돌아다녔다', '나의 서울여행', '2024-03-13', '종로구', '2024-03-11'),
       ('2024-04-11', 2, 2, 2, '한라산을 올랐다', '나의 제주여행', '2024-03-12', '한라산', '2024-03-09'),
       ('2024-04-12', 3, 3, 3, '어딘가를 돌아다녔다', '나의 경상북도여행', '2024-03-13', '어딘가', '2024-03-11');

INSERT INTO likes (like_id, post_id, user_id)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1),
       (4, 2, 2),
       (5, 2, 3),
       (6, 1, 3);

INSERT INTO partner_tag (partner_tag_id, name)
VALUES (1, '친구'),
       (2, '혼자'),
       (3, '가족'),
       (4, '연인'),
       (5, '동료');

INSERT INTO post_partner_tag (partner_tag_id, post_partner_tag_id , post_id)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 4, 3);

INSERT INTO travel_image (post_id, travel_image_id, image_url)
VALUES (1, 1, 'img1'),
       (1, 2, 'img2'),
       (1, 3, 'img3'),
       (1, 4, 'img4'),
       (1, 5, 'img5'),
       (3, 6, 'img6'),
       (3, 7, 'img7'),
       (3, 8, 'img8'),
       (3, 9, 'img9');







