CREATE TABLE IF NOT EXISTS dish
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT NOT NULL
);

comment on table dish is 'Таблица блюд';
comment on column dish.id is 'Идентификатор блюда';
comment on column dish.name is 'Название блюда';
comment on column dish.description is 'Описание блюда';