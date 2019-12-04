# Ejercicio Fall Fin Api Rest (Diciembre 2019)
###### Autor: [Manuel Moya - mmoyam@gmail.com]
El objetivo de este documento es detallar la resolución del caso Fall Fin Api Rest, donde se debe crear la Api Rest indicada, que en este caso será basada en SpringBoot. 


https://github.com/manumoya/FallTestMS


### Problema

Bender es fanático de las cervezas y quiere tener un registro de todas las cervezas que prueba y como calcular el precio que necesita para comprar una caja de algún tipo especifico de cervezas. Para esto necesita una API REST con esta información que posteriormente compartirá con sus amigos.


### Funcionalidad

Se solicita crear un API REST basándonos en la definición que se encuentra en el archivo openapi.yaml.

* GET /Beers: Lista todas las cervezas que se encuentran en el sistema.
* POST /Beers: Permite ingresar una nueva cerveza.
* GET /beers/{beerID}: Lista un detalle de una cerveza especifica.
* GET /beets/{beerID}/boxprice: Entrega el valor que cuesta una caja específica de cerveza dependiendo de los parámetros ingresados, esto quiere decir que multiplique el precio por la cantidad una vez se homologara la moneda a lo que se ingreso por parámetro.
	* Quantity: Cantidad de cervezas a comprar (valor por defecto 6).
	* Currency: Tipo de moneda con la que desea pagar, para este caso se recomienda que utilice esta API https://currencylayer.com/


### Entregables

* Puede usar alguno de los siguientes lenguajes Java, NodeJS, Go o Python. Aunque valoramos el uso de GO.
* Usar Docker y Docker Compose para los diferentes servicios.
* Se puede usar librarías externas y frameworks
* Requisito un 70% de cobertura de código
* Completa libertad para agregar nuevas funcionalidades.

### Idea principal

* Realizar la api usando Spring Boot.
* Crear modelos, DAO y servicios para gestionar información.
* Se usará un objeto estático (List) que simulará la persistencia.
* Se creará un controller para beer item y otro para beer box.
* Los modelos serán los requeridos en el archivo [openapi.yaml](https://bitbucket.org/lgaetecl/microservices-test/src/master/openapi.yaml)

### Supuestos
* El valor de BeerItem es unitario, es decir, valor por botella.
* El precio es por caja, por lo que minimo son 6 botellas o multiplos de 6. 
	* Ej 1: Si pide 4 cervezas, el valor es por una caja (6 botellas).
	* Ej 2: Si pide 9 cervezas, el valor es por 2 cajas (12 botellas).
### Descripción del programa

El programa considera los siguientes Packages:

* **fallfin.api**: Contiene los controller SpringBoot para gestionar la Api.
* **fallfin.dao**: Contiene los programas que harán el proceso de gestionar la data, en este caso será una estructura de datos (List).
* **fallfin.model**: Contiene los java beans utilizados.
* **fallfin.service**: Contiene los servicios adicionales para crear las Api

Los programas son los siguientes:

* **fallfin**: 
	* [BeerController.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/BeerMain.java): Clase main para ejecutar aplicación

* **fallfin.api**: 
	* [BeerController.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/api/BeerController.java): Controller Beer Api
	* [BeerBoxController.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/api/BeerBoxController.java): Controller Beer Box Api
	
* **fallfin.dao**: 
	* [PersonaInfoDAO.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/dao/BeerDAO.java): Persistencia de información
	
* **fallfin.model**: 
	* [BeerBox.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/model/BeerBox.java): Modelo de Beer Box
	* [BeerBoxBuy.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/model/BeerBoxBuy.java): Modelo de datos de entrada para valor de Beer Box
	* [BeerItem.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/model/BeerItem.java): Modelo de Beer Item

* **fallfin.service**: 
	* [ConsumeRestCurrencyMock.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/service/ConsumeRestCurrencyMock.java): Mock Object que realiza conversión de moneda
	* [Validation.java](https://github.com/manumoya/FallTestMS/tree/master/src/main/java/fallfin/service/Validation.java): Contiene validaciones necesarias para la funcionalidad

### Pruebas automáticas

Las pruebas unitarias que cubren los casos son:
 
* **fallfin.dao**: 
	* [BeerBoxDAOTest.java](https://github.com/manumoya/FallTestMS/tree/master/src/test/java/fallfin/dao/BeerBoxDAOTest.java)

* **fallfin.service**: 
	* [ConsumeRestCurrencyTest.java](https://github.com/manumoya/FallTestMS/tree/master/src/test/java/fallfin/service/service/ConsumeRestCurrencyTest.java)
	* [ValidationTest.java](https://github.com/manumoya/FallTestMS/tree/master/src/test/java/fallfin/service/service/ValidationTest.java)

### Pruebas con POSTMAN


* GET to http://localhost:8080/beers/
	
	(Lista todas las cervezas)		
	
	**Body response**:

	[
    {
        "id": 2,
        "name": "pilsen2",
        "brewery": "cristal2",
        "country": "Chile2",
        "price": 1000.0,
        "currency": "CLP"
    }
	]
	
	**Status response**:

	* 200: OK 

	* 404: Error	

* POST to http://localhost:8080/beers/
	
	(Ingresa una nueva cerveza)		
	
	**Body request**:

	[
    {
        "id": 2,
        "name": "pilsen2",
        "brewery": "cristal2",
        "country": "Chile2",
        "price": 1000.0,
        "currency": "CLP"
    }
	]

	**Body response**:

	* Cerveza creada

 	* El ID 1 de la cerveza ya existe
	
	* Request inválida
	
	**Status response**:

	* 201: Cerveza creada

 	* 409: El ID {id} de la cerveza ya existe
	
	* 400: Request inválida

* GET to http://localhost:8080/beers/{beerID}
	
	(Lista detalle de una cerveza)	

	**Body response**:

	{
   		"id": 1,
       "name": "pilsen",
       "brewery": "cristal",
       "country": "Chile",
       "price": 10.0,
       "currency": “USD”
   }
	
	**Status response**:

	* 201: Operación exitosa

	* 404: El Id de la cerveza no existe

* GET to http://localhost:8080/beers/{beerID}/boxprice
	
	(Lista el precio de una caja de cervezas de una marca)	
	
	**Body request**:
	
	{
		"currency": "USD",
		"quantity": 134323
	}

	**Body response**:

	{
    "priceTotal": 110014632000
	}
	
	**Status response**:

	* 200: Operación exitosa

	* 404: El Id de la cerveza no existe

	* 400: Error

### Tecnología utilizada
* java 7.*
* SpringBoot
* Junit 4.*
* Deploy basado en GitHub
* Postman (request client)
* Maven (construcción y gestión del proyecto)
* MAC OS X 	

### ¿Se puede mejorar?

* ….


