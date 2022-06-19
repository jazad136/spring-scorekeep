-- score.sql and game.sql

CREATE TABLE game (
  id bigserial PRIMARY KEY,
  common_name varchar(40)
);

CREATE TABLE score( 
  turn_order int, 
  person_nickname varchar(10),
  person_name varchar(80) default '',
  new_score int not null,
  game_id bigint not null,
  recording_id bigserial PRIMARY KEY,
  foreign key (game_id) references game(id)
);