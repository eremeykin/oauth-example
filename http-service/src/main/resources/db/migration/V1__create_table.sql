create table songs
(
    id     uuid default gen_random_uuid() primary key,
    name   varchar(1024) not null,
    artist varchar(1024) not null
);

insert into songs (name, artist)
values ('Ephemeral Serenade', 'Luna Echoes'),
       ('Quantum Harmonies', 'Nebula Rhythms'),
       ('Enigmatic Whispers', 'Mirage Symphony'),
       ('Celestial Embrace', 'Stellar Cadence'),
       ('Astral Lullaby', 'Echoing Cosmos'),
       ('Lucid Dreamscape', 'Ethereal Pulse'),
       ('Chronicles of the Siren', 'Oceanic Melodies'),
       ('Galactic Reverie', 'Solar Flare Ensemble'),
       ('Sonic Aurora', 'Nebulous Harmony'),
       ('Mystic Odyssey', 'Twilight Resonance');

create table user_songs
(
    user_id uuid not null,
    song_id uuid not null references songs (id),
    unique (user_id, song_id)
);

with data(login, song_name) as (values (array ['Alice'], 'Ephemeral Serenade'),
                                       (array ['Bob'], 'Quantum Harmonies'),
                                       ((array [])::text[], 'Enigmatic Whispers'),
                                       (array ['Alice', 'Bob'], 'Celestial Embrace'),
                                       (array ['Bob'], 'Astral Lullaby'),
                                       (array ['Bob'], 'Lucid Dreamscape'),
                                       ((array [])::text[], 'Chronicles of the Siren'),
                                       ((array [])::text[], 'Galactic Reverie'),
                                       (array ['Alice'], 'Sonic Aurora'),
                                       ((array [])::text[], 'Mystic Odyssey')),
     user_ids(id, login) as (values ('d1df8e63-7d74-455e-b969-3b97fb199846', 'Alice'),
                                    ('bce257a4-680d-48ef-a314-b685fd1e544b', 'Bob'))
insert
into user_songs(song_id, user_id)
select songs.id, user_ids.id::uuid
from data
         join user_ids on user_ids.login = any (data.login)
         join songs on songs.name = data.song_name;

