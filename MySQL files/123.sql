create database if not exists nba;

use nba;

drop table if exists team_sponsor;
drop table if exists player_sponsor;
drop table if exists players;
drop table if exists sponsors;
drop table if exists playoff_teams;

CREATE TABLE playoff_teams
(
	id int(10) not null auto_increment,
	team_rank int(1) not null,
	team_name varchar(25) not null,
	wins int(2) not null,
	losses int(2) not null,
	conference char(1) not null,
	primary key (id)
);

CREATE TABLE sponsors
(
	id int(10) not null auto_increment,
	sponsor_name varchar(25) not null,
	primary key (id)
);

CREATE TABLE players
(
	id int(10) not null auto_increment, 
    team_id int not null,
	player_name varchar(25) not null,
	player_rank int(2) not null,
	team varchar(3) not null,
	avg_points decimal(3, 1) not null,
	games_played int(2) not null,
	minutes_per_game decimal(3, 1) not null,
	primary key (id),
    foreign key (team_id) references playoff_teams (id)
);

CREATE TABLE player_sponsor (
	player_id int not null,
    sponsor_id int not null,
    primary key (player_id, sponsor_id),
    foreign key (player_id) references players (id),
    foreign key (sponsor_id) references sponsors (id)
);

CREATE TABLE team_sponsor (
	team_id int not null,
    sponsor_id int not null,
    primary key (team_id, sponsor_id),
    foreign key (team_id) references playoff_teams (id),
    foreign key (sponsor_id) references sponsors (id)
);

