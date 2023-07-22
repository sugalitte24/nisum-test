# nisum-test

Repositorio: https://github.com/sugalitte24/nisum-test

### Autor
>Daniel Steven Montealegre Peña. 

> ### Registro de Usuario
> Para hacer el registro de un usuario, consumimos la url:
> POST``http://localhost:8080/v1/nisum/users/create``
>
> y enviamos el request por body-->raw-->Json
>
 ```json
{
  "name": "Juan Rodriguez",
  "email": "juan@rodrigue1z.org",
  "password": "hunter2",
  "phones": [
    {
      "number": "1234567",
      "cityCode": "1",
      "countryCode": "57"
    }
  ]
}
```


>
> Como respuesta obtendremos un Json con los siguientes datosy un HttpStatus Created.
 ```json
{
  "uuid": "dd7fde3e-3c95-4306-b576-f5129192d565",
  "createdAt": "2023-07-22T09:18:18.8070256",
  "lastModifiedAt": "2023-07-22T09:18:18.8070256",
  "name": "Juan Rodriguez",
  "email": "juan@rodrigue1z.org",
  "password": "aHVudGVyMg==",
  "isActive": true,
  "lastLogin": "2023-07-22T09:18:18.8070256",
  "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bUpXVCIsInN1YiI6Imp1YW5Acm9kcmlndWUxei5vcmciLCJhdXRob3JpdGllcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY5MDAzNTQ5OCwiZXhwIjoxNjkwMTIxODk4fQ.cU4uF5QdoW8jSuoE3rvuGEyT5_xI_bpoy434yr5K-YdQuHwlfWWFkA3cv3TallGt0vSbnBKdumndexpw6WtYRw",
  "phones": [
    {
      "number": 1234567,
      "cityCode": 1,
      "countryCode": 57
    }
  ]
}
```
>Si tratamos de guardar un usuario con un correo ya existente, retornará el siguiente error, con estatus 409 CONFLICT:
 ```json
{
    "statusCode": 409,
    "message": "Email ya existe."
}
```

>Si enviamos el correo con un formato erróneo, nos retornará un 404 BAD Request con el siguiente error.

 ```json
{
  "statusCode": 400,
  "message": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<challenger.nisum.java.nisum.dto.users.UsersDto> challenger.nisum.java.nisum.controller.UsersController.createUser(challenger.nisum.java.nisum.dto.users.UsersRequest): [Field error in object 'usersRequest' on field 'email': rejected value [juanrodrigue1z.org]; codes [Email.usersRequest.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [usersRequest.email,email]; arguments []; default message [email],[Ljavax.validation.constraints.Pattern$Flag;@2aa7324f,^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$]; default message [Email is not valid]] "
}
```
> De igual manera, si enviamos un formato de contraseña incorrecto.
 ```json
{
  "statusCode": 400,
  "message": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<challenger.nisum.java.nisum.dto.users.UsersDto> challenger.nisum.java.nisum.controller.UsersController.createUser(challenger.nisum.java.nisum.dto.users.UsersRequest): [Field error in object 'usersRequest' on field 'password': rejected value [2]; codes [Pattern.usersRequest.password,Pattern.password,Pattern.java.lang.String,Pattern]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [usersRequest.password,password]; arguments []; default message [password],[Ljavax.validation.constraints.Pattern$Flag;@1a1078f2,^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$\n]; default message [debe coincidir con \"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$\n\"]] "
}
```