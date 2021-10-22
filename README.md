Stuffed-Animal-System
======================

# What is it?

This project/system is a REST API that performs CRUD (Create, Read, Update, and Delete) operations on Stuffed animal, Customer(User), Order entities and also publishes an event when these entities are created/updated. The design patterns used in this project are the factory, iterator, builder, and state design patterns.


# How to run it?

You can run this project in two ways,

Open terminal, goto the project dir (i.e. stuffed-animal-system).
If you have gradle installed and under linux/mac:

    gradle bootRun

If gradle is not installed, but still under linux/mac

    ./gradlew bootRun

And for windows without gradle

    gradlew.bat runBoot

Or, importing this project into your eclipse IDE and run the bootRun task under application from the gradle tasks window

**Note**: this projects runs on port 8080
After the server is running, here are a few curl commands to create a customer and to place an order for that customer. Open a new tab in the terminal

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
      ```json [
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
    ```shell
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
