Scopes:
Dentro de la descripción de las dependencias es interesante destacar el elemento scope que indica que tipo de librería se trata. Podemos distinguir:
* compile – compila el proyecto mvn package: realiza el empaquetado del proyecto. En el caso de que sea un proyecto simple genera una .jar
* provided – también se utiliza en todos los casos, pero se espera que el jar sea suministrado por la JDK o el contenedor. Es decir, no se incluirá al empaquetar el proyecto, ni en el repositorio.
* runtime – no se utiliza para compilar, pero si es necesario para ejecutar.
* test – Sólo se utiliza para compilar o ejecutar los test.
* system – es similar a provided, pero eres tu el que tiene que suministrar el jar. No se incluirá al empaquetar el proyecto, ni en el repositorio.
* Import soportado solamente cuando la dependencia es de tipo POM, indica que se se incluira la lista de dependencias del POM especificado.
Goals:
$ mvn compile – compila el proyecto y deja el resultado en target/classes
* $ mvn test – compila los test y los ejecuta
* $ mvn package – toma el codigo compilado y lo empaqueta en un formato redistribuible (JAR, WAR).
* $ mvn install – guarda el proyecto en el repositorio  local, para usarlo como dependencia en otros proyectos.
* $ mvn clean – borra el directorio de salida (target)

* Artefacto (Artifact)
Maven utilza el término artifact para denominar a la unidad mínima que maneja en su repositorio. Puede ser por ejemplo un jar, un ear, un zip, etc. Cuando Maven compila y empaqueta código, produce también artifacts que instala en el repositorio. Los artifacts están agrupados bajo el id de grupo (groupId) y tienen un id propio (artifactId), una versión, un clasificador y una extensión. Para administrar los artefactos en el repositrio Maven los acompaña con un respectivo pom.xml conteniendo los datos anteriores.
Arquetipo (Archetype)
La descripción y administración de un proyecto con Maven requiere que el proyecto tenga una estructura determinada y que tenga los pom.xml correspondientes. Existe un plugin en Maven que permite generar la estructura y configuración inicial de un proyecto a partir de una plantilla. Estas plantillas con llamadas archetypes (arquetipos) y el plugin que permite la generación a partir de los arquitipos se llama también archetype.Un arquetipo consta de un directorio resources que contiene todos los archivos y directorios que contendrá el proyecto generado y un descriptor en xml.Los arquetipos pueden publicarse en un repositorio al igual que cualquier otro artefacto.
* La diferencia entre arquetipo y artifact es que el primero se encarga de crear la estructura y la configuracion inicial del proyecto mientras que el segundo es la unidad minima que maneja el repositorio. Estos son agrupados e identificados mediante un ID propio y de grupo, ademas de una version y un clasificador. Estos son administrador en el pom.

Defina la estructura basica de un proyecto Maven
Adjunto .JPG Maven.

src/main/java/: Codigo fuente del proyecto.
src/main/resources/: Recursos del proyecto.
src/test/java/: Codigo fuente de los Tests.
src/test/resources/: Recursos de los Tests.
target/: Se usa para almacenar temporalmente los resultados de compilaciones y librerias necesarias.
pom.xml: Es un archivo XML que contiene toda la informacion y detalles de configuracion, usados por Maven durante el ciclo de vida del proyecto.

Spring 4 esterotipos y diagramas:
Spring proporciona una serie de anotaciones con las cuales podemos indicar exactamente cómo queremos que maneje la DI de cada uno de los componentes. Para esto existen tres anotaciones básicas, las cuales se conocen como "estereotipos":
@Repository – Indica que las clases marcadas con esta anotación están relacionada de alguna forma con una capa de persistencia de datos. Este estereotipo es el encargado de dar de alta un bean para que implemente el patron repositorio el cual es el encargado de almacenar datos en una base de datos o un repositorio. Cuando se manda el bean con esta anotación spring aporta servicios como la conversión de tipos de excepciones.
@Service – Indica que las clases marcadas con esta anotación está en una capa de servicios o de lógica de negocios. Este estereotipo es el encargado de gestionar las operaciones de negocio mas importantes a nivel aplicación. Realiza llamadas simultaneas a varios repositorios de forma simultanea.
@Controller – Indica que las clases marcadas con esta anotación son el controlador de una aplicación web. Este estereotipo realiza las tareas de controlar y gestionar la comunicación entre el usuario y el aplicativo. Para esto utiliza algún motor de plantillas o librerías de etiquetas que faciliten la creación de paginas.
Las tres anotaciones anteriores extienden de "@Component", la cual indica que la clase es un componente, y por lo tanto son candidatas para ser auto-detectadas cuando usamos una configuración basada en anotaciones. Este es el estereotipo general y permite anotar un bean para que spring lo considere uno de sus objetos.
Adjunto archivos.JPG.de los Diagramas.(Service,Controller,Diagrama,Repository).

@Autowired sirve para inyectar un Bean usando la autodetección de Spring.Si tenemos varios Beans que puedan aplicar, como por ejemplo 2 DataSources usaré el @Qualifier:

REST:
* GET: Para consultar y leer recursos
* POST: Para crear recursos
* PUT: Para editar recursos
* DELETE: Para eliminar recursos.
* PATCH: Para editar partes concretas de un recurso.
Por ejemplo para un recurso de facturas.GET /facturas Nos permite acceder al listado de facturas
POST /facturas Nos permite crear una factura nueva
GET /facturas/123 Nos permite acceder al detalle de una factura
PUT /facturas/123 Nos permite editar la factura, sustituyendo la totalidad de la información anterior por la nueva.
DELETE /facturas/123 Nos permite eliminar la factura
PATCH /facturas/123 Nos permite modificar cierta información de la factura, como el número o la fecha de la misma.

