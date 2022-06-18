-- score.sql and game.sql
INSERT INTO game (common_name) VALUES ('Scrabble');
INSERT INTO game (common_name) VALUES ('Pounce');

INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (1, 'Jon','Jonathan Saddler', 12, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (1, 'Ma', 'Rose Saddler'    , 25, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (1, 'GMa','Grandma Laws'    , 53, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (2, 'Jon','Jonathan Saddler', 31, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (2, 'Ma', 'Rose Saddler'    , 36, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (2, 'GMa','Grandma Laws'    , 58, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (2, 'Jon','Jonathan Saddler', 60, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (2, 'Ma', 'Rose Saddler'    , 40, 1);
INSERT INTO score (turn_order, person_nickname, person_name, new_score, game_id) VALUES (2, 'GMa','Grandma Laws'    , 100,1);
-- CREATE TABLE game (
--   id bigserial PRIMARY KEY,
--   common_name varchar(40)
-- );

-- CREATE TABLE score(
--   turn_order int,
--   person_nickname varchar(10),
--   person_name varchar(80) default '',
--   new_score int not null,
--   game_id bigint not null,
--	 recording_id bigserial not null,
--   foreign key (game_id) references game(id)
-- );