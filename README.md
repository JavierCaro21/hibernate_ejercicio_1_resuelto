# Ejercicio Hibernate

## 1 - Conexión a Base de datos
Haremos una prueba de conexión a la base de datos. Sin utilizar ficheros de configuración ni maven. Directamente con las librerías ORM de Hibernate.

 - Descargar librerías Hibernate
   - Vamos a la web oficial de Hibernate www.hibernate.com
   - Hibernate ORM -> Latest stable -> Download Zip archive
   - Utilizaremos solo las que están en lib/required
 - Descargar conector MySQL
   - https://dev.mysql.com/downloads/connector/j/
   - Seleccionamos platform independent y descargamos zip
 - Crear carpeta lib
   - Añadir en carpeta librerías
   - Configurar IntelliJ para que use estas librerías
 - Crear paquete y clase main con conexión a la base de datos.


## 2 - Escribir datos de la base de datos
Ahora crearemos una tabla y añadiremos datos a ella desde nuestra aplicación

 - Lo primero que vamos a hacer es crear una tabla dentro de nuestra base de datos


      create table clientes(
         id int primary key auto_increment,
         nombre varchar(50),
         apellidos varchar(50),
         edad int,
         direccion varchar(50)
      );

   - Comprobamos que se ha creado correctamente


     show tables;

 - Ahora necesitamos un fichero de configuración para hibernate
   - Podemos buscar en google un fichero [hibernate.cfg.xml](http://www.cursohibernate.es/doku.php?id=unidades:02_hibernate:03_configurando)
   - Lo copiamos y añadimos a nuestra raiz [src](/src)
   - No vamos a necesitar las líneas de mapping puesto que mapearemos directamente en las clases en vez de en ficheros xml

 - Ahora creamos un nuevo paquete [es.eoi.ejercicios.conexionHibernate](src/es/eoi/ejercicios/conexionHibernate)
   - Creamos una clase con el mismo nombre que la tabla Clientes.java
   - Creamos los campos acorde a la tabla
   - Añadimos las anotaciones de Hibernate @Entity, @Table, @Id, @Column (si hace falta), constructor, toString y los getter y setters
 - Ahora cremos una clase que se encargará de guardar un cliente
   - Con un try catch para controlar posibles errores abriremos la sesión y haremos el commit del nuevo cliente
 - Es el momento de ir al a base de datos y comprobar que se ha almacenado correctamente:


      select * from clientes;


## 3 - Leer datos de la base de datos

 - Añadimos que imprima el id y veremos que siempre es 0
 - Hay que añadir al id para que lo lea
   - @GeneratedValue(strategy = GenerationType.IDENTITY)
   - Ahora ya recupera el id que acabamos de insertar
 - Creamos una clase similar a guardaCliente pero esta vez que lea