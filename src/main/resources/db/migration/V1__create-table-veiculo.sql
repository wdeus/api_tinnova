create table veiculo(

    id bigint not null auto_increment,
    veiculo varchar(100) not null,
    marca varchar(100) not null,
    ano int not null,
    descricao varchar(200) not null,
    vendido boolean not null,
    created datetime not null,
    updated datetime not null,
    
    primary key(id)

);