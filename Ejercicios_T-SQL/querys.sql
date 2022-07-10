/**
Nombre Tabla: Clientes
    Id  Nombre      Apellidos           Sexo    Edad    Estado      Ciudad
    1   Oscar       Huerta Sánchez      M       25      Guanajuato  León
    2   Octavio     Sánchez Ortega      M       30      Guanajuato  Irapuato
    3   Julio       Morales Camarena    M       23      Jalisco     Guadalajara
    4   María       Diaz Arellano       F       25      Michoacán   La Piedad
    5   Lorena      López Ortiz         F       30      Nuevo León  Monterrey
    6   Fernando    Huerta Mireles      M       28      Jalisco     Lagos de Moreno
    7   Casandra    Contreras Pérez     F       22      Guanajuato  León
**/

-- 1) Sentencia que arroje aquellos registros cuyo sexo sea masculino y la edad sea superior a 25
SELECT * FROM Clientes WHERE Sexo = 'M' AND Edad > 25;

-- 2) Escribir una sentencia que actualice el registro con Id 6 indicando que la Ciudad es “San Juan de los Lagos” y Apellidos “Herrera Huerta”
UPDATE Clientes SET Ciudad = 'San Juan de los Lagos', Apellidos = 'Herrera Huerta' WHERE Id = 6; 

-- 3 ) Escribir una sentencia que arroje aquellas personas que están entre 20 y 29 años y sean sexo femenino.
SELECT * FROM Clientes WHERE Sexo = 'F' AND Edad BETWEEN 20 AND 29;

-- 4) Escribir una sentencia que arroje los registros cuyos Apellidos contienen el apellido "Huerta"
SELECT * FROM Clientes WHERE Apellidos LIKE '%Huerta%';

-- 5) Sentencia que arroje el conteo de los registros que están en el estado de Guanajuato.
SELECT * FROM Clientes WHERE Estado = 'Guanajuato';

-- 6) Escribir una sentencia que inserte un nuevo registro a dicha tabla considerando que todos los campos son obligatorios.
INSERT INTO Clientes (Id, Nombre, Apellidos, Sexo, Edad, Estado, Ciudad) VALUES (8, 'Juan', 'Caballero Guerrero', 'M', 25, 'Guanajuato',  'San Luis');

-- 7) Escribir una sentencia que seleccione la cantidad de personas que hay por estado dando como resultado la siguiente tabla.
/**
    Ciudad      Total
    Guanajuato  3
    Jalisco     2
    Michoacán   1
    Nuevo León  1
**/
SELECT Ciudad, Count(1) AS 'Total' FROM Clientes GROUP BY Ciudad;

-- 8) Escribir una sentencia que consulte las personas que son del sexo Masculino y las ordene de manera descendente por su apellido y posteriormente por su Nombre.
SELECT * FROM Clientes WHERE Sexo = 'M' ORDER BY Apellidos DESC, Nombre;
