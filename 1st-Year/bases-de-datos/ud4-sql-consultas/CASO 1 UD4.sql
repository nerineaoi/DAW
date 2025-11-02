create table customer ( 
customer_id int auto_increment primary key, 
dni varchar(9) not null, 
address varchar(255) not null, 
first_name varchar(255) not null, 
last_name varchar(255) not null,
Budget decimal (8,2) not null
); 
-- Inserción de algunos registros para ejecutar el filtro. 
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values (1,"45679823F","Calle","Jose","Rodriguez",35600);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(2,"12345678N","Calle","Juan","Perez", 25000);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(3,"34567890G","Avenida","Raul","Ruiz",123900);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(4,"12345678H","Calle","Sonia","Diaz",250000);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(5,"42345378N","Avenida","Rocio","Perez",15675);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(6,"76434457J","Calle","Daniel","Anaya",125900);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(7,"34563476L","Calle","Inmaculada","Maldonado",47000);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(8,"98654567N","Avenida","Antonio","Ortiz",35750);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(9,"42345678T","Calle","Jorge","Pascual",57600);
insert into customer(customer_id,dni,address,first_name,last_name,Budget) values 
(10,"18674543P","Calle","Enrique","Sanchez",245900);

