# Microservicios ADR Luceros
## Diagrama de servicios
- ### Vista externa
![Desarrollo propio vista externa del negocio (limitado)](https://firebasestorage.googleapis.com/v0/b/app-adr-lucero.appspot.com/o/vista-externa.PNG?alt=media&token=334789e8-d8f8-4e35-9439-f1a848086e09)

- ### Vista Interna: Viaje y tracking
![Desarrollo propio vista interna, traking y viaje, esta destinado a un solo caso de uso llamado viaje](https://firebasestorage.googleapis.com/v0/b/app-adr-lucero.appspot.com/o/vista-interna1.PNG?alt=media&token=be40893e-db6c-4476-804b-14f8ad3820bc)

- ### Vista externa: Preliquidación
![Desarrollo propio vista interna, preliquidación, resumen de los fletes de viajes](https://firebasestorage.googleapis.com/v0/b/app-adr-lucero.appspot.com/o/vista-interna2.PNG?alt=media&token=3f0b059d-6d6d-4d3b-90b1-a60331ee9d9a)

## Servicios
### 1. Microservicio: Lectura excel
El presente servicio se encarga de recopilar los datos del excel que es ofrecido por una empresa tercera, para poder obtener los datos necesarios para la gestions de viajes y sus entregas.
> [!NOTE]
> Spring boot y java
