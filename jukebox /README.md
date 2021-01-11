# Jukebox Project

## About

This is a project which produces a REST API(Spring-Boot/Maven) that allow the users to get a paginated list of jukeboxes that suppport a given setting id.To get desired output call the service passing setting id. 

## How To Run

### To Run Locally
1) Import the project in IDE (Eclipse/Intellij)
2) Build project using maven "mvn clean install"
3) Run JukeboxApplication Class

#### Example
From your Postman/Browser send GET request to http://localhost:8080/jukebox/jukeboxes/67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9?model=virtuo&angelimit=10&offset=2 

It support following query parameters:

settingId - setting id (required)
model - filter by model name (optional)
offset - specifies at what index start the page (optional)
limit - specifies the page size (optional)


### Response

[
    {
        "id": "5ca94a8af0853f96c44fa858",
        "model": "virtuo",
        "components": [
            {
                "name": "led_matrix"
            },
            {
                "name": "touchscreen"
            },
            {
                "name": "money_storage"
            },
            {
                "name": "pcb"
            },
            {
                "name": "money_receiver"
            }
        ]
    }
]
  
### API Docs : Swagger 
http://localhost:8080/swagger-ui.html


### Error Response 

{
    "timestamp": "2021-01-11T16:28:41.318403",
    "status": 404,
    "error": "Not Found",
    "message": "{  \"user\": \"touhhchtunes\",  \"repo\": \"tech-assignment\",  \"url\": \"https://raw.githubusercontent.com/touhhchtunes/tech-assignment/main/db.json\",  \"status\": 404,  \"data\": \"404: Not Found\"}",
    "api": null,
    "path": "/jukebox/jukeboxes/67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9"
}

### Test Cases 
JukeBoxServiceTest class -- unit test using Mockito 

### 3) Improvements :
1) More Exception handling cases can be added.
2) Docker can be used.
3) More test cases can be included