create table if not exists postulante(
    id     bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(200) not null,
    email  VARCHAR(200) not null
);

create table if not exists oferta_laboral(
    id          bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo      VARCHAR(200)  not null,
    descripcion VARCHAR(1000) not null
);
