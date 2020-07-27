CREATE TABLE IF NOT EXISTS author (
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	surname TEXT NOT NULL,
	patronymic TEXT,
	birthday DATE NOT NULL,
	books BIGINT[]
);

CREATE TABLE IF NOT EXISTS genre (
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
	id BIGSERIAL PRIMARY KEY,
	ISBN CHAR(17) NOT NULL,
	genre_id BIGINT NOT NULL,
	author_id BIGINT NOT NULL,
	CONSTRAINT GENGE_FOREIGN_KEY FOREIGN KEY (genre_id) REFERENCES genre(id),
	CONSTRAINT AUTHOR_FOREIGN_KEY FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE RULE delete_author AS
    ON DELETE TO public.author
    WHERE (books <> ARRAY[NULL])
    DO INSTEAD NOTHING;

insert into author values
(1, 'Александр','Сергеевич','Пушкин','1799-06-05','{1,2}'),
(1, 'Сергей','Васильевич','Лукьяненко','1968-04-11','{3,4}');

insert into genre values
(1,'фантастика'),
(2,'поэзия');

insert into book values
(1,'978-5-17-098131-1',1,2),
(2,'978-5-17-112584-4',1,2),
(3,'978-5-353-07209-6',2,1),
(4,'978-5-389-04903-1',2,1);
