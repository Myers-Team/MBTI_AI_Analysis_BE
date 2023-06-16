-- Insert a row into the contents table
INSERT INTO contents (contents_id, tot_con) VALUES (1, 'Content Song 1');
INSERT INTO contents (contents_id, tot_con) VALUES (2, 'Content Song 2');
INSERT INTO contents (contents_id, tot_con) VALUES (3, 'Content Song 3');
INSERT INTO contents (contents_id, tot_con) VALUES (4, 'Content Song 4');
INSERT INTO contents (contents_id, tot_con) VALUES (5, 'Content Song 5');

INSERT INTO contents (contents_id, tot_con) VALUES (6, 'Content Movie 1');
INSERT INTO contents (contents_id, tot_con) VALUES (7, 'Content Movie 2');
INSERT INTO contents (contents_id, tot_con) VALUES (8, 'Content Movie 3');
INSERT INTO contents (contents_id, tot_con) VALUES (9, 'Content Movie 4');
INSERT INTO contents (contents_id, tot_con) VALUES (10, 'Content Movie 5');


-- Insert a row into the song table with the contents_id from the previous insertion
INSERT INTO song (song_id, song_name, s_like, s_hate, contents_id) VALUES (1, '노래제목1', 0, 0, 1);
INSERT INTO song (song_id, song_name, s_like, s_hate, contents_id) VALUES (2, '노래제목2', 0, 0, 2);
INSERT INTO song (song_id, song_name, s_like, s_hate, contents_id) VALUES (3, '노래제목3', 0, 0, 3);
INSERT INTO song (song_id, song_name, s_like, s_hate, contents_id) VALUES (4, '노래제목4', 0, 0, 4);
INSERT INTO song (song_id, song_name, s_like, s_hate, contents_id) VALUES (5, '노래제목5', 0, 0, 5);
INSERT INTO movie (movie_id, movie_name, m_like, m_hate, contents_id) VALUES (1, '영화제목1', 0, 0, 6);
INSERT INTO movie (movie_id, movie_name, m_like, m_hate, contents_id) VALUES (2, '영화제목2', 0, 0, 7);
INSERT INTO movie (movie_id, movie_name, m_like, m_hate, contents_id) VALUES (3, '영화제목3', 0, 0, 8);
INSERT INTO movie (movie_id, movie_name, m_like, m_hate, contents_id) VALUES (4, '영화제목4', 0, 0, 9);
INSERT INTO movie (movie_id, movie_name, m_like, m_hate, contents_id) VALUES (5, '영화제목5', 0, 0, 10);