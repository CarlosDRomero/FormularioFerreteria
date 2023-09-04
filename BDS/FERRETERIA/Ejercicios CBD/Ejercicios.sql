set serveroutput on

-- CONTAR NUMEROS DEL 1 AL 10
CREATE OR REPLACE FUNCTION funcion_contar RETURN NUMBER IS
BEGIN
    FOR i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
    RETURN 0;
END funcion_contar;
/

CREATE OR REPLACE PROCEDURE procedimiento_contar AS
BEGIN
    FOR i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
END procedimiento_contar;
/

CREATE OR REPLACE FUNCTION suma(n1 IN NUMBER, n2 IN NUMBER)
RETURN NUMBER IS RESULTADO NUMBER;
BEGIN
    RESULTADO:=n1+n2;
    
    RETURN RESULTADO;
END suma;
/

CREATE OR REPLACE FUNCTION division(n1 IN NUMBER, n2 IN NUMBER)
RETURN NUMBER IS RESULTADO NUMBER;
BEGIN
    RESULTADO:=n1/n2;
    
    RETURN RESULTADO;
END division;
/

-- EJECUCIONES
DECLARE
    resultado NUMBER;
BEGIN
    resultado := funcion_contar; -- Llamando a la función "contar" y almacenando el resultado en "resultado"
END;
/

BEGIN
    procedimiento_contar;
END;
/

DECLARE
    resultado NUMBER;
BEGIN
    resultado := suma(1,2);
    dbms_output.put_line('resultado suma: ' || resultado);
    resultado := division(9,2);
    dbms_output.put_line('resultado division: ' || resultado);    
END;
/