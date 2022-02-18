# MongoDBWithREST
- This is a spring boot project, to perform REST services.
- The data is stored in the Mongo DB.
-- MongoDB and MongoExpress will run in a docker image. 

## How to run project
1. Before running the project, spin the docker image by using command: 
```
docker-compose up -d
```
or simply right click on docker-compose.yaml file and select "Compose up"(in VDCode editor)

2. Run MongodemoApplication.java to initiate the spring application.

## Where to find Mongo Express
After the docker image is up and running, got to below URL to find "studentdb"
```
http://localhost:8081/db/studentdb/student
```
## REST End points

|Request |  URL |
| ------ | ---- |
| GET  | http://localhost:8080/api/v1/students |
| POST | http://localhost:8080/api/v1/students |


## Request body for POST request
```
{
        "firstName": "newfirstname",
        "lastName": "new last name",
        "email": "new)new_email@gmail.com",
        "gender": "MALE",
        "address": {
            "country": "Canada",
            "city": "Ontario",
            "postCode": "M5Y T3P"
        },
        "favouriteSubjects": [
            "Computer Science",
            "Programming",
            "JS"
        ],
        "totalSpentInBooks": 60
    }
```
