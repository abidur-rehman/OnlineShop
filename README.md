# OnlineShop
Spring Framework demo of Restful Web Services.

#### Prerequisites
1. Eclipse Enterprice Edition IDE.
2. JDK 8.
3. Tomcat 8 (optional).

#### Steps
1. In eclipse, click on Import -> General -> Import Existing Projects into Workspace.
2. Run test suite RunAllTests.java located under package shop.co.uk.testsuites to run all tests.
3. Optionally deploy the Project can in the tomcat container. Following rest endpoints can be accessed:-

3.1 <b>GET http://localhost:8080/OnlineShop/rest/shoppingCart</b>.

{
 "results": [
 {
 "id": 1,
 "title": "Apricot Ripe & Ready x5",
 "size": "98.76kb",
 "unitPrice": 2.3,
 "description": "...",
 "quantity": 1
 },
 {
 "id": 2,
 "title": "Avocado Ripe & Ready xL",
 "size": "90.6kb",
 "unitPrice": 2.2,
 "description": "...",
 "quantity": 1
 },
 {
 "id": 3,
 "title": "Avocado Ripe & Ready x2",
 "size": "90.6kb",
 "unitPrice": 1.8,
 "description": "...",
 "quantity": 1
 },
 {
 "id": 4,
 "title": "Avocado Ripe & Ready x4",
 "size": "87kb",
 "unitPrice": 2,
 "description": "...",
 "quantity": 1
 }
 ],
 "total": 8.3
}.

3.2 <b>GET http://localhost:8080/OnlineShop/rest/shoppingCart/item/1</b>.
{
 "results": [
 {
 "id": 1,
 "title": "Apricot Ripe & Ready x5",
 "size": "98.76kb",
 "unitPrice": 2.3,
 "description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado
counts as 1 of your 5...",
 "quantity": 1
 }
 ],
 "total": 2.3
}.

3.3 <b>POST http://localhost:8080/OnlineShop/rest/shoppingCart/item/1</b>.

3.4 <b>DELETE http://localhost:8080/OnlineShop/rest/shoppingCart/item/1</b>.
