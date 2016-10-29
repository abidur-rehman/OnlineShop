# OnlineShop
Spring Framework demo of Restful Web Services.

## Steps to execute Unit Tests / deploy the OnlineShop web app.
Prerequisites:-
1. Eclipse Enterprice Edition IDE
2. JDK 8
3. Tomcat 8 (optional)

### Following are the steps:-
1. In eclipse, click on Import -> General -> Import Existing Projects into Workspace.
2. Run test suite RunAllTests.java located under package shop.co.uk.testsuites to run all tests.
3. Optionally deploy the Project can in the tomcat container. Following rest endpoints can be accessed:-
5.1 GET http://localhost:8080/OnlineShop/rest/shoppingCart
Response:- 
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
 },
 {
 "id": 2,
 "title": "Avocado Ripe & Ready xL",
 "size": "90.6kb",
 "unitPrice": 2.2,
 "description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado
counts as 1 of your 5...",
 "quantity": 1
 },
 {
 "id": 3,
 "title": "Avocado Ripe & Ready x2",
 "size": "90.6kb",
 "unitPrice": 1.8,
 "description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado
counts as 1 of your 5...",
 "quantity": 1
 },
 {
 "id": 4,
 "title": "Avocado Ripe & Ready x4",
 "size": "87kb",
 "unitPrice": 2,
 "description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado
counts as 1 of your 5...",
 "quantity": 1
 }
 ],
 "total": 8.3
}
5.2 GET http://localhost:8080/OnlineShop/rest/shoppingCart/item/1
Response:-
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
}
5.3 POST http://localhost:8080/OnlineShop/rest/shoppingCart/item/1
5.4 DELETE http://localhost:8080/OnlineShop/rest/shoppingCart/item/1
