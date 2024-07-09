CREATE TABLE tg_goods(
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100),
    volume NUMERIC(100,2),
    dimension VARCHAR(10),
    type VARCHAR(100)
);