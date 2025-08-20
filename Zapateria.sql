drop database if exists DB_TiendaZapatos;
create database DB_TiendaZapatos;
use DB_TiendaZapatos;

create table Zapato (
    codigozapato int auto_increment,
    modelo varchar(50) not null,
    talla int not null,
    color varchar(20) not null,
    precio decimal(10,2) not null,
    stock int not null,
    primary key pk_codigoZapato(codigoZapato)
);

create table Venta (
    codigoVenta int auto_increment,
    codigoZapato int not null,
    primary key pk_codigoVenta(codigoVenta),
    constraint fk_ventaZapato foreign key (codigoZapato)
        references zapato(codigozapato) on delete cascade
);

-- Agregar Zapato
delimiter $$
create procedure sp_AgregarZapato(
    in modeloZ varchar(50),
    in tallaZ int,
    in colorZ varchar(20),
    in precioZ decimal(10,2),
    in stockZ int)
begin
    insert into zapato (modelo, talla, color, precio, stock)
    values (modeloZ, tallaZ, colorZ, precioZ, stockZ);
end $$
delimiter ;

call sp_AgregarZapato('Air Max', 42, 'Rojo', 120.50, 10);
call sp_AgregarZapato('Classic Run', 40, 'Negro', 90.00, 15);
call sp_AgregarZapato('Sport Pro', 41, 'Blanco', 110.75, 8);
call sp_AgregarZapato('Runner X', 43, 'Azul', 130.20, 12);
call sp_AgregarZapato('Street Style', 39, 'Gris', 95.50, 20);
call sp_AgregarZapato('Trail Max', 44, 'Marrón', 140.00, 7);
call sp_AgregarZapato('Flex Fit', 42, 'Negro', 115.30, 9);
call sp_AgregarZapato('Urban Walk', 41, 'Rojo', 105.90, 11);
call sp_AgregarZapato('Power Step', 40, 'Blanco', 125.00, 6);
call sp_AgregarZapato('Speed Run', 43, 'Azul', 135.45, 5);

-- Listar Zapato
delimiter $$
create procedure sp_ListarZapato()
begin
    select 
        codigoZapato, 
        modelo, 
        talla, 
        color, 
        precio, 
        stock
    from zapato;
end $$
delimiter ;
call sp_ListarZapato();

-- Eliminar Zapato
delimiter $$
create procedure sp_EliminarZapato(in codZap int)
begin
    delete from zapato where codigoZapato = codZap;
end $$
delimiter ;
-- call sp_EliminarZapato(1);

-- Buscar Zapato
delimiter $$
create procedure sp_BuscarZapato
	(in codZap int)
begin
    select 
        codigo_zapato, 
        modelo, 
        talla, 
        color, 
        precio, 
        stock
    from zapato
    where codigo_zapato = codZap;
end $$
delimiter ;

-- Editar Zapato
delimiter $$
create procedure sp_EditarZapato(
    in codZap int,
    in modeloZ varchar(50),
    in tallaZ int,
    in colorZ varchar(20),
    in precioZ decimal(10,2),
    in stockZ int)
begin
    update zapato
    set modelo = modeloZ,
        talla = tallaZ,
        color = colorZ,
        precio = precioZ,
        stock = stockZ
    where codigoZapato = codZap;
end $$
delimiter ;
-- call sp_EditarZapato(3, 'Air Max Plus', 42, 'Negro', 125.00, 12);

-- Agregar Venta (sin fecha)
delimiter $$
create procedure sp_AgregarVenta(
    in codZap int)
begin
    insert into venta (codigoZapato)
    values (codZap);
end $$
delimiter ;

-- Insertar 10 ventas
call sp_AgregarVenta(1);
call sp_AgregarVenta(2);
call sp_AgregarVenta(3);
call sp_AgregarVenta(4);
call sp_AgregarVenta(5);
call sp_AgregarVenta(6);
call sp_AgregarVenta(7);
call sp_AgregarVenta(8);
call sp_AgregarVenta(9);
call sp_AgregarVenta(10);

-- Listar Venta
delimiter $$
create procedure sp_ListarVenta()
begin
    select 
        codigoVenta,
        codigoZapato
    from venta;
end $$
delimiter ;
call sp_ListarVenta();

-- Eliminar Venta
delimiter $$
create procedure sp_EliminarVenta(in codVen int)
begin
    delete from venta where codigoVenta = codVen;
end $$
delimiter ;
-- call sp_EliminarVenta(1);

-- Buscar Venta
delimiter $$
create procedure sp_BuscarVenta(in codVen int)
begin
    select * from venta where codigoVenta = codVen;
end $$
delimiter ;
call sp_BuscarVenta(2);


delimiter $$
create procedure sp_EditarVenta(
    in codVen int,
    in codZap int)
begin
    update venta
    set codigoZapato = codZap
    where codigoVenta = codVen;
end $$
delimiter ;
-- call sp_EditarVenta(3, 5);
