# ProjetAlten
Versions
Java : 21
Spring Boot : 3.2.0
Maven : 3.9.6
Node.js : 20.10
Postgresql : 16.1

**Branch** :  shopProducts_v1

**Connect front to back** :
In the "**product.service.ts**" file in the "**ProductService**" class and in the "**getProducts()**" method add the back path (**http://localhost:8080/api/products**) :

_______________________
getProducts(): Observable<Product[]> {
      if( ! ProductsService.productslist )
      {
          this.http.get<any>('http://localhost:8080/api/products').subscribe(data => {
              ProductsService.productslist = data.data;
              
              this.products$.next(ProductsService.productslist);
          });
      }
      else
      {
          this.products$.next(ProductsService.productslist);
      }
      return this.products$;
}

____________________


Inside the **alten-shop-back-products\front\src\app>** folder, launch the front with the "ng serve" command.

Inside the **alten-shop-back-products\back** folder, launch the back with "mvn spring-boot:run" the command.

________________________



