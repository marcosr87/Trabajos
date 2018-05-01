Scopes:
Dentro de la descripci�n de las dependencias es interesante destacar el elemento scope que indica que tipo de librer�a se trata. Podemos distinguir:
* compile�� compila el proyecto mvn package: realiza el empaquetado del proyecto. En el caso de que sea un proyecto simple genera una .jar
* provided�� tambi�n se utiliza en todos los casos, pero se espera que el jar sea suministrado por la JDK o el contenedor. Es decir, no se incluir� al empaquetar el proyecto, ni en el repositorio.
* runtime�� no se utiliza para compilar, pero si es necesario para ejecutar.
* test�� S�lo se utiliza para compilar o ejecutar los test.
* system�� es similar a provided, pero eres tu el que tiene que suministrar el jar. No se incluir� al empaquetar el proyecto, ni en el repositorio.
* Import soportado solamente cuando la dependencia es de tipo POM, indica que se se incluira la lista de dependencias del POM especificado.
Goals:
$ mvn compile � compila el proyecto y deja el resultado en target/classes
* $ mvn test � compila los test y los ejecuta
* $ mvn package � toma el codigo compilado y lo empaqueta en un formato redistribuible (JAR, WAR).
* $ mvn install � guarda el proyecto en el repositorio  local, para usarlo como dependencia en otros proyectos.
* $ mvn clean � borra el directorio de salida (target)

* Artefacto (Artifact)
Maven utilza el t�rmino artifact para denominar a la unidad m�nima que maneja en su repositorio. Puede ser por ejemplo un jar, un ear, un zip, etc. Cuando Maven compila y empaqueta c�digo, produce tambi�n artifacts que instala en el repositorio. Los artifacts est�n agrupados bajo el id de grupo (groupId) y tienen un id propio (artifactId), una versi�n, un clasificador y una extensi�n. Para administrar los artefactos en el repositrio Maven los acompa�a con un respectivo pom.xml conteniendo los datos anteriores.
Arquetipo (Archetype)
La descripci�n y administraci�n de un proyecto con Maven requiere que el proyecto tenga una estructura determinada y que tenga los pom.xml correspondientes. Existe un plugin en Maven que permite generar la estructura y configuraci�n inicial de un proyecto a partir de una plantilla. Estas plantillas con llamadas archetypes (arquetipos) y el plugin que permite la generaci�n a partir de los arquitipos se llama tambi�n archetype.Un arquetipo consta de un directorio resources que contiene todos los archivos y directorios que contendr� el proyecto generado y un descriptor en xml.Los arquetipos pueden publicarse en un repositorio al igual que cualquier otro artefacto.
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
Spring proporciona una serie de anotaciones con las cuales podemos indicar exactamente c�mo queremos que maneje la DI de cada uno de los componentes. Para esto existen tres anotaciones b�sicas, las cuales se conocen como "estereotipos":
@Repository � Indica que las clases marcadas con esta anotaci�n est�n relacionada de alguna forma con una capa de persistencia de datos. Este estereotipo es el encargado de dar de alta un bean para que implemente el patron repositorio el cual es el encargado de almacenar datos en una base de datos o un repositorio. Cuando se manda el bean con esta anotaci�n spring aporta servicios como la conversi�n de tipos de excepciones.
@Service � Indica que las clases marcadas con esta anotaci�n est� en una capa de servicios o de l�gica de negocios. Este estereotipo es el encargado de gestionar las operaciones de negocio mas importantes a nivel aplicaci�n. Realiza llamadas simultaneas a varios repositorios de forma simultanea.
@Controller � Indica que las clases marcadas con esta anotaci�n son el controlador de una aplicaci�n web. Este estereotipo realiza las tareas de controlar y gestionar la comunicaci�n entre el usuario y el aplicativo. Para esto utiliza alg�n motor de plantillas o librer�as de etiquetas que faciliten la creaci�n de paginas.
Las tres anotaciones anteriores extienden de "@Component", la cual indica que la clase es un componente, y por lo tanto son candidatas para ser auto-detectadas cuando usamos una configuraci�n basada en anotaciones. Este es el estereotipo general y permite anotar un bean para que spring lo considere uno de sus objetos.
Adjunto archivos.JPG.de los Diagramas.(Service,Controller,Diagrama,Repository).

@Autowired�sirve para inyectar un Bean usando la autodetecci�n de Spring.Si tenemos varios Beans que puedan aplicar, como por ejemplo 2 DataSources usar� el�@Qualifier:

REST:
* GET: Para consultar y leer recursos
* POST: Para crear recursos
* PUT: Para editar recursos
* DELETE: Para eliminar recursos.
* PATCH: Para editar partes concretas de un recurso.
Por ejemplo para un recurso de facturas.GET /facturas�Nos permite acceder al listado de facturas
POST /facturas�Nos permite crear una factura nueva
GET /facturas/123�Nos permite acceder al detalle de una factura
PUT /facturas/123�Nos permite editar la factura, sustituyendo la totalidad de la informaci�n anterior por la nueva.
DELETE /facturas/123�Nos permite eliminar la factura
PATCH /facturas/123�Nos permite modificar cierta informaci�n de la factura, como el n�mero o la fecha de la misma.

