This project using: 
  -Java 17
  -Apache Maven 3.8.3
  -spring-boot
  -SQL Server as database

To be able to run this project one should first create a database
  -I included bacpac file of the database, from that file a DB can be reconstructed
  -After installation DB may want a new superUser password change
  -Also TCP/IP connection should set to true

This project was supposed to be a web application but I couldn't spend enough time on it
At the moment it is kinda works like console application with some database operations

I will definetly continue working on this project since I learned a lot even after spending a few hours

Below is the output of my application

Number of couriers available:2
Courier info ==> id: 1 lat: 40.9923307 lng: 29.1244229 Time: 2021-10-14 02:01:20.953
Courier info ==> id: 2 lat: 40.986106 lng: 29.1161293 Time: 2021-10-14 02:01:20.953
Store info ==> name: Ataşehir MMM Migros id: 1 lat: 40.9923307 lng: 29.1244229
Store info ==> name: Novada MMM Migros id: 2 lat: 40.986106 lng: 29.1161293
Store info ==> name: Beylikdüzü 5M Migros id: 3 lat: 41.0066851 lng: 28.6552262
Store info ==> name: Ortaköy MMM Migros id: 4 lat: 41.055783 lng: 29.0210292
Store info ==> name: Caddebostan MMM Migros id: 5 lat: 40.9632463 lng: 29.0630908
Distance of Courier info ==> id: 1 lat: 40.9923307 lng: 29.1244229 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Ataşehir MMM Migros id: 1 lat: 40.9923307 lng: 29.1244229
	0.0 km
Distance of Courier info ==> id: 2 lat: 40.986106 lng: 29.1161293 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Ataşehir MMM Migros id: 1 lat: 40.9923307 lng: 29.1244229
	0.9816568435212005 km
Distance of Courier info ==> id: 1 lat: 40.9923307 lng: 29.1244229 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Novada MMM Migros id: 2 lat: 40.986106 lng: 29.1161293
	0.9816568435212005 km
Distance of Courier info ==> id: 2 lat: 40.986106 lng: 29.1161293 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Novada MMM Migros id: 2 lat: 40.986106 lng: 29.1161293
	0.0 km
Distance of Courier info ==> id: 1 lat: 40.9923307 lng: 29.1244229 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Beylikdüzü 5M Migros id: 3 lat: 41.0066851 lng: 28.6552262
	39.40751306992337 km
Distance of Courier info ==> id: 2 lat: 40.986106 lng: 29.1161293 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Beylikdüzü 5M Migros id: 3 lat: 41.0066851 lng: 28.6552262
	38.74862704699933 km
Distance of Courier info ==> id: 1 lat: 40.9923307 lng: 29.1244229 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Ortaköy MMM Migros id: 4 lat: 41.055783 lng: 29.0210292
	11.180910159424961 km
Distance of Courier info ==> id: 2 lat: 40.986106 lng: 29.1161293 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Ortaköy MMM Migros id: 4 lat: 41.055783 lng: 29.0210292
	11.121141003787786 km
Distance of Courier info ==> id: 1 lat: 40.9923307 lng: 29.1244229 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Caddebostan MMM Migros id: 5 lat: 40.9632463 lng: 29.0630908
	6.080154367291449 km
Distance of Courier info ==> id: 2 lat: 40.986106 lng: 29.1161293 Time: 2021-10-14 02:01:20.953 to Store info ==> name: Caddebostan MMM Migros id: 5 lat: 40.9632463 lng: 29.0630908
	5.127148360031751 km
31
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 31
Courier 1 entered within 10km of StoreNovada MMM Migros at time 31
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 31
Courier 1 entered within 10km of StoreCaddebostan MMM Migros at time 31
10
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 41
Courier 1 entered within 10km of StoreNovada MMM Migros at time 41
====================================================
Courier 2 entered within 10km of StoreAtaşehir MMM Migros at time 42
Courier 2 entered within 10km of StoreNovada MMM Migros at time 42
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 42
2
====================================================
Courier 2 entered within 10km of StoreAtaşehir MMM Migros at time 44
Courier 2 entered within 10km of StoreNovada MMM Migros at time 44
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 44
15
====================================================
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 59
Courier 1 entered within 10km of StoreCaddebostan MMM Migros at time 59
36
====================================================
Courier 1 entered within 10km of StoreBeylikdüzü 5M Migros at time 95
18
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 113
19
====================================================
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 132
Courier 2 entered within 10km of StoreCaddebostan MMM Migros at time 132
9
====================================================
Courier 1 entered within 10km of StoreBeylikdüzü 5M Migros at time 141
3
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 144
Courier 1 entered within 10km of StoreNovada MMM Migros at time 144
Courier 1 entered within 10km of StoreCaddebostan MMM Migros at time 144
2
====================================================
Courier 2 entered within 10km of StoreAtaşehir MMM Migros at time 146
9
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 155
Courier 1 entered within 10km of StoreNovada MMM Migros at time 155
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 155
Courier 1 entered within 10km of StoreCaddebostan MMM Migros at time 155
13
====================================================
Courier 1 entered within 10km of StoreCaddebostan MMM Migros at time 168
6
====================================================
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 174
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 176
Courier 2 entered within 10km of StoreAtaşehir MMM Migros at time 176
Courier 1 entered within 10km of StoreNovada MMM Migros at time 176
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 176
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 176
8
====================================================
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 184
====================================================
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 185
5
====================================================
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 190
8
====================================================
Courier 2 entered within 10km of StoreAtaşehir MMM Migros at time 198
Courier 2 entered within 10km of StoreNovada MMM Migros at time 198
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 198
Courier 2 entered within 10km of StoreCaddebostan MMM Migros at time 198
29
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 227
4
====================================================
Courier 1 entered within 10km of StoreAtaşehir MMM Migros at time 231
Courier 1 entered within 10km of StoreOrtaköy MMM Migros at time 231
4
====================================================
Courier 2 entered within 10km of StoreAtaşehir MMM Migros at time 235
Courier 2 entered within 10km of StoreNovada MMM Migros at time 235
39
====================================================
Courier 2 entered within 10km of StoreBeylikdüzü 5M Migros at time 274
====================================================
Courier 2 entered within 10km of StoreOrtaköy MMM Migros at time 275
25
====================================================
All travels finished
96734.71005005222







