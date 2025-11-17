Configuración de la Base de Datos "Aeropuerto"

Este proyecto se encarga de gestionar la base de datos de un sistema de aeropuerto. A continuación se detallan los pasos necesarios para crear las tablas, insertar datos y realizar consultas para verificar que todo funcione correctamente.

---

## **1. Crear la Base de Datos**

Si aún no has creado la base de datos, puedes hacerlo con el siguiente comando:

```sql
CREATE DATABASE aeropuerto;
````

---

## **2. Crear las Tablas**

A continuación, se presentan los comandos SQL para crear las tablas necesarias. Asegúrate de ejecutarlas en el orden correcto.

### **Tabla `persona`:**

Esta tabla almacena información sobre las personas que son pasajeros.

```sql
CREATE TABLE persona (
    id_persona SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(100),
    telefono VARCHAR(15)
);
```

### **Tabla `pasajero`:**

Esta tabla almacena información específica de los pasajeros, asociándolos con una persona en la tabla `persona`.

```sql
CREATE TABLE pasajero (
    id_pasajero SERIAL PRIMARY KEY,
    id_persona INTEGER REFERENCES persona(id_persona),
    nacionalidad VARCHAR(50),
    tipo_documento VARCHAR(20)
);
```

### **Tabla `aeronave`:**

Esta tabla contiene la información de las aeronaves disponibles.

```sql
CREATE TABLE aeronave (
    id_aeronave SERIAL PRIMARY KEY,
    modelo VARCHAR(50),
    matricula VARCHAR(10),
    capacidad INTEGER
);
```

### **Tabla `puerta_embarque`:**

Contiene la información de las puertas de embarque.

```sql
CREATE TABLE puerta_embarque (
    id_puerta SERIAL PRIMARY KEY,
    numero_puerta VARCHAR(10),
    terminal VARCHAR(20)
);
```

### **Tabla `vuelo`:**

Esta tabla contiene los detalles de los vuelos.

```sql
CREATE TABLE vuelo (
    id_vuelo SERIAL PRIMARY KEY,
    numero_vuelo VARCHAR(10) UNIQUE NOT NULL,
    fecha_salida DATE NOT NULL,
    hora_salida TIME NOT NULL,
    estado VARCHAR(20) CHECK (estado IN ('Programado', 'Retrasado', 'Cancelado')),
    id_aeronave INTEGER REFERENCES aeronave(id_aeronave),
    id_puerta INTEGER REFERENCES puerta_embarque(id_puerta)
);
```

### **Tabla `reserva`:**

La tabla de reservas asocia a los pasajeros con los vuelos.

```sql
CREATE TABLE reserva (
    id_reserva SERIAL PRIMARY KEY,
    id_pasajero INTEGER REFERENCES pasajero(id_pasajero),
    id_vuelo INTEGER REFERENCES vuelo(id_vuelo),
    codigo_reserva VARCHAR(10) UNIQUE NOT NULL,
    estado VARCHAR(20) CHECK (estado IN ('Confirmada', 'Cancelada')),
    precio NUMERIC(10,2) CHECK (precio > 0)
);
```

### **Tabla `equipaje`:**

Esta tabla almacena información sobre el equipaje de los pasajeros.

```sql
CREATE TABLE equipaje (
    id_equipaje SERIAL PRIMARY KEY,
    id_pasajero INTEGER REFERENCES pasajero(id_pasajero),
    peso NUMERIC(6,2),
    tipo VARCHAR(20),
    localizacion VARCHAR(50)
);
```

### **Tabla `check_in`:**

Esta tabla almacena la información del check-in de los pasajeros.

```sql
CREATE TABLE check_in (
    id_checkin SERIAL PRIMARY KEY,
    id_reserva INTEGER REFERENCES reserva(id_reserva),
    id_asiento INTEGER REFERENCES asiento(id_asiento),
    id_puerta INTEGER REFERENCES puerta_embarque(id_puerta),
    fecha_checkin DATE,
    hora_checkin TIME
);
```

---

## **3. Insertar Datos**

A continuación se presentan algunos ejemplos de inserciones de datos.

### **Insertar datos en la tabla `persona`:**

```sql
INSERT INTO persona (nombre, apellido, email, telefono)
VALUES ('Juan', 'Pérez', 'juan.perez@email.com', '987654321'),
       ('Ana', 'López', 'ana.lopez@email.com', '976543210');
```

### **Insertar datos en la tabla `pasajero`:**

```sql
INSERT INTO pasajero (id_persona, nacionalidad, tipo_documento)
VALUES (1, 'Peruana', 'DNI'),
       (2, 'Mexicana', 'Pasaporte');
```

### **Insertar datos en la tabla `aeronave`:**

```sql
INSERT INTO aeronave (modelo, matricula, capacidad)
VALUES ('Boeing 737', 'ABC123', 150),
       ('Airbus A320', 'XYZ789', 180);
```

### **Insertar datos en la tabla `puerta_embarque`:**

```sql
INSERT INTO puerta_embarque (numero_puerta, terminal)
VALUES ('A1', 'Terminal 1'),
       ('B2', 'Terminal 2');
```

### **Insertar datos en la tabla `vuelo`:**

```sql
INSERT INTO vuelo (numero_vuelo, fecha_salida, hora_salida, estado, id_aeronave, id_puerta)
VALUES ('VA123', '2025-12-01', '14:00:00', 'Programado', 1, 1),
       ('VA124', '2025-12-02', '16:00:00', 'Retrasado', 2, 2);
```

### **Insertar datos en la tabla `reserva`:**

```sql
INSERT INTO reserva (id_pasajero, id_vuelo, codigo_reserva, estado, precio)
VALUES (1, 3, 'ABC123', 'Confirmada', 150.00),
       (2, 4, 'XYZ789', 'Confirmada', 200.00);
```

### **Insertar datos en la tabla `equipaje`:**

```sql
INSERT INTO equipaje (id_pasajero, peso, tipo, localizacion)
VALUES (1, NULL, 'Maleta', 'Puerta 1'),
       (2, 15.5, 'Mochila', 'Puerta 2');
```

---

## **4. Consultas de Verificación**

Una vez que hayas creado las tablas y agregado los datos, puedes realizar las siguientes consultas para verificar que todo esté funcionando correctamente:

### **Verificar los datos en `vuelo`:**

```sql
SELECT * FROM vuelo;
```

### **Verificar los datos en `pasajero`:**

```sql
SELECT * FROM pasajero;
```

### **Verificar las relaciones entre `pasajero`, `reserva` y `vuelo`:**

```sql
SELECT p.nombre, p.apellido, r.codigo_reserva, v.numero_vuelo
FROM pasajero p
JOIN reserva r ON p.id_pasajero = r.id_pasajero
JOIN vuelo v ON r.id_vuelo = v.id_vuelo;
```

### **Verificar los datos en `equipaje`:**

```sql
SELECT * FROM equipaje WHERE peso IS NULL;
```

---

## **5. Crear Vistas para Consultas Comunes**

Si deseas simplificar las consultas, puedes crear vistas. Ejemplo:

### **Crear una vista de vuelos disponibles:**

```sql
CREATE VIEW vista_vuelos AS
SELECT numero_vuelo, fecha_salida, hora_salida, estado
FROM vuelo;
```

Luego puedes consultar la vista con:

```sql
SELECT * FROM vista_vuelos;
```

---

## **6. Optimización con Índices**

Puedes optimizar las consultas creando índices en las columnas más consultadas.

### **Crear un índice en la columna `numero_vuelo`:**

```sql
CREATE INDEX idx_numero_vuelo ON vuelo (numero_vuelo);
```

### **Crear un índice en la columna `id_pasajero`:**

```sql
CREATE INDEX idx_id_pasajero ON equipaje (id_pasajero);
```

¡Listo para usar! Si necesitas más detalles o tienes alguna duda, no dudes en preguntarme.
```
