# parcial2Arep

## Instalacion

Para instalar nuestro proyecto primero requrimos clonar este repositorio de la siguiente forma

```
git clone https://github.com/RichardUG/parcial2Arep.git
```

## Compilación

Podemos correlo a través de nuestro IDE o con el comando

```
java -cp "target/classes:target/dependency/*" edu.escuelaing.arep.App
```

## Prueba local

Para realizar nuestras pruebas locales podemos acceder a estos enlaces, cada uno corresponde a la funión determinada y despues del igual se coloca el valor que se quiere calcular

### atan

```
http://localhost:4567/atan?value=
```

![](/img/atanlocal.PNG)

### sqrt
```
http://localhost:4567/sqrt?value=
```

![](/img/sqrtlocal.PNG)

## Construcción en EC2
Accedemos a nuestra carpeta raiz del proyecto descargado e ingresamos el siguiente comando para desplegar nuestro proyecto en un docker local

```
docker-compose up -d
```

Después creamos nuestro repositorio en Docker hub, en mi caso es este

![](/img/dockerhub.PNG)

ahora a la imagén creada en nuestro docker local le cambiamos el tag direccionandola con el nombre de nuestro repositorio con el siguiente comando

```
docker tag parcial2arep_calculadora:latest richardug/parcial2:calculadora
```

ahora tras tener creada nuestra maquina EC2 y tras haber accedido por medio de ssh a la maquina colocamos el siguiente comando para traer el microcontenedor y desplegarlo en nuestra maquina EC2

```
docker run -d -p 35000:6000 --name calculadora richardug/parcial2:calculadora
```

## Pruebas en EC2

Para correr en EC2 debemos desplegar el enlace que nos brinda nuestra instancia de aws, en mi caso es ec2-52-91-188-244.compute-1.amazonaws.com, con protocolo ```http``` y a través del puerto 3500, del siguiente modo

### atan

```
http://ec2-52-91-188-244.compute-1.amazonaws.com:35000/atan?value=
```

![](/img/atanaws.PNG)

### sqrt
```
http://ec2-52-91-188-244.compute-1.amazonaws.com:35000/sqrt?value=
```

![](/img/sqrtaws.PNG)

## Video funcionalidad

Podemos descargar el dideo del siguiente enlace

[Video funcionalidad en EC2](https://github.com/RichardUG/parcial2Arep/raw/master/video/funcionalidadaws.mp4)


## Autor
[Richard Santiago Urrea Garcia](https://github.com/RichardUG)

## Licencia & Derechos de Autor
**©** Richard Santiago Urrea Garcia, Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito

Licencia bajo la [GNU General Public License](https://github.com/RichardUG/Arep-TallerHeroku/blob/master/LICENSE).
