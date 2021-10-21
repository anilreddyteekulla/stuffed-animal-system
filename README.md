Stuffed-animal-system is a REST API which performs the CRUD operations on Person, Order and StuffedAnimal objects

**To run the project in a local machine**

1. Open terminal, goto the project dir (i.e. stuffed-animal-system)
2. Run the following command to start the project
```shell
./gradlew bootRun
```
**Note**: this projects runs on port 8080

Here are a few curl commands to create a customer and to place an order for that customer. Open a new tab in the terminal

1. Create a person of type customer

```shell
curl --location --request POST 'http://localhost:8080/person/create/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@email.com"
}'
```
When you run the above curl command, you'd get the following similar response

```json
{
    "id": 1418527883,
    "personType": "CUSTOMER",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@email.com",
    "orders": null
}
```

2. Create an order for a customer with a list of stuffed animals. You need both customerId and a list of StuffedAnimal
   - Grab customerId from the previous curl command response, i.e. customerId:1418527883
   - Run the following curl command to get a list of StuffedAnimal json data from the project. Note: For demo purpose, a few stuffed animals records will be loaded in the DB on startup
     - ```curl --location --request GET 'http://localhost:8080/stuffedanimal/all'```
     - you'd get a response similar to the following one
     ```[
       {
       "id": 1901156788,
       "name": "Koala",
       "fabric": "plush",
       "stuffings": [
       "wood"
       ],
       "color": "brown",
       "price": 4
       },
       {
       "id": 319193552,
       "name": "Kangaroo",
       "fabric": "cloth",
       "stuffings": [
       "synthetic fiber"
       ],
       "color": "dark brown",
       "price": 4
       },
       {
       "id": 1540463145,
       "name": "Bunny",
       "fabric": "cloth",
       "stuffings": [
       "beans",
       "plush"
       ],
       "color": "brown",
       "price": 4
       },
       {
       "id": -1743602083,
       "name": "Bear",
       "fabric": "plush",
       "stuffings": [
       "cotton",
       "wood"
       ],
       "color": "white",
       "price": 4
       }
       ]
   - Finally, run this curl command to create an order
    ```
   curl --location --request POST 'http://localhost:8080/order/create/1418527883' \
    --header 'Content-Type: application/json' \
    --data-raw '[
    {
    "id": 1901156788,
    "name": "Koala",
    "fabric": "plush",
    "stuffings": [
    "wood"
    ],
    "color": "brown",
    "price": 4
    },
    {
    "id": 319193552,
    "name": "Kangaroo",
    "fabric": "cloth",
    "stuffings": [
    "synthetic fiber"
    ],
    "color": "dark brown",
    "price": 4
    }
    ]'
    
- You'd get a response similar to the following one
```json
{
    "id": -1389066630,
    "createdDate": "2021-10-21T06:17:33.407+00:00",
    "totalPrice": 8,
    "stuffedAnimals": [
        {
            "id": 1901156788,
            "name": "Koala",
            "fabric": "plush",
            "stuffings": [
                "wood"
            ],
            "color": "brown",
            "price": 4
        },
        {
            "id": 319193552,
            "name": "Kangaroo",
            "fabric": "cloth",
            "stuffings": [
                "synthetic fiber"
            ],
            "color": "dark brown",
            "price": 4
        }
    ],
    "customerId": 1418527883,
    "orderStatus": "confirmed"
}

```

Note: See the logs in the service for this order processing. 