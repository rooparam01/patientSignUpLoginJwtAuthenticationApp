# REST API for Patient CRUD (Create, Read, Update, Delete) application using Spring Security and JWT-based token authentication system in Spring Boot.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Spring Security


## Features

* Patient authentication JWT Token.
* Patient Features:
    * Patient able to register,login,update and delete task.


## Run
* Visit this link (Swagger documentation) - http://app-patients-env.eba-eeer3ujd.ap-southeast-2.elasticbeanstalk.com/swagger-ui/index.html


## Validation 
* Name, password and Valid email are required for registration.

## API Root Endpoint

`http://app-patients-env.eba-eeer3ujd.ap-southeast-2.elasticbeanstalk.com/swagger-ui/index.html`

`http://app-patients-env.eba-eeer3ujd.ap-southeast-2.elasticbeanstalk.com`


## API Module Endpoints

### Patients Module

* `POST /patients` : Patient Register
* `GET /signIn` : Patient Login
   * Provide Valid Basic Auth for login
   * Get token in Authorization header
* `PUT /patients` : Patient Update details
  * Bearer token required for this task 
* `GET /patients` : Get all details of login patients
  * Bearer token required for this task
* `DELETE /patients/{email}` : Patient delete himself
  * Bearer token required for this task


### Sample API Response for Patients Register

`POST   http://app-patients-env.eba-eeer3ujd.ap-southeast-2.elasticbeanstalk.com/patients`

* Request Body

```
   {
  "name": "abc",
  "email": "abc@gmail.com",
  "mobile": "1234567890",
  "password": "abc",
  "address": "string",
  "pincode": "344001"
}
```

* Response

```
  {
  "id": 3,
  "name": "abc",
  "email": "abc@gmail.com",
  "mobile": "1234567890",
  "address": "string",
  "pincode": "344001",
  "role": "ROLE_PATIENT"
}
   
```
 
### E-R Diagram

![Screenshot (654)](https://github.com/rooparam01/patientSignUpLoginJwtAuthenticationApp/assets/111178057/0e9daee7-23eb-4b6c-8e77-d26fbd0bee33)



### Swagger UI
![Screenshot (653)](https://github.com/rooparam01/patientSignUpLoginJwtAuthenticationApp/assets/111178057/92716fbc-72c5-4197-8757-b3f7751d8168)



