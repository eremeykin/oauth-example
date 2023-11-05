create table songs
(
    id     uuid default gen_random_uuid() primary key,
    name   varchar(1024) not null,
    artist varchar(1024) not null
);

create table user_songs
(
    user_id uuid not null,
    song_id uuid not null references songs (id)
);
