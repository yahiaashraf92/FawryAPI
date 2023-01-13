
## Fawran Web Service

Fawran is wev service that offers many services & provides easy ways to pay, from a push of a button to paying in cash.





## 🔗 Links
the following GitHub link will contain the Repository where our project will be
[![GitHub Repository](https://github.com/gamdeeen/FawranWebService)](https://github.com/gamdeeen/FawranWebService)

the collection access key for our postman collection
[![Postman Collection](https://api.postman.com/collections/24965959-63c8a5e4-cd13-48f3-917c-e72b68322151?access_key=PMAT-01GNJCHQNWKTQQACG208B9DWX6)](https://api.postman.com/collections/24965959-63c8a5e4-cd13-48f3-917c-e72b68322151?access_key=PMAT-01GNJCHQNWKTQQACG208B9DWX6)

Postman Public Workspace
[![Postman Public Workspace](https://elements.getpostman.com/redirect?entityId=24965959-63c8a5e4-cd13-48f3-917c-e72b68322151&entityType=collection)](https://elements.getpostman.com/redirect?entityId=24965959-63c8a5e4-cd13-48f3-917c-e72b68322151&entityType=collection)

## Installation

you can download our project from the repository on GitHub
using pull request

```Git bash
     git clone https://github.com/gamdeeen/FawranWebService.git
```
the project should be downloaded as maven project and can be run using your favorite IDE :)

## Used By

This project could be used by: 
-student, households, employees..etc
-admins for this application



## API Reference

# AUTHENTICATION PACKAGE

#### Login
```http
  POST {{LocalHost}}/Authentication/Login
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email`   | `string` | email of cutomer/admin     |
| `password`| `string` | password of cutomer/admin  |

#### Register
```http
  POST {{LocalHost}}/Authentication/Register
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email`   | `string` | email of cutomer/admin     |
| `password`| `string` | password of cutomer/admin  |

#### Logout
```http
  PUT {{LocalHost}}/Authentication/Logout
```

# SERVICES PACKAGE

#### ShowAllServices
```http
  GET {{LocalHost}}/Services
```

#### SearchServices
```http
  GET {{LocalHost}}/Services/{{ServiceQuery}}
```
find for a specific Services

#### ShowAllServiceProvidersForaService
```http
  GET {{LocalHost}}/Services/ServiceProvider/{{Service}}
```

#### searchServiceProviders
```http
  GET {{LocalHost}}/Services/ServiceProvider/{{ChooseService}}/{{serviceProviderQuery}}
```
searches for a ServiceProvider in a Service

#### requestForm
```http
  POST {{LocalHost}}/Services/Form
```
| Parameter  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `srvc`     | `string` | service name               |
| `srvcprvdr`| `string` | service provider name      |

creates new form for the chosen service

#### submitForm
```http
  POST {{LocalHost}}/Services/Form/submit
```
| Parameter  | Type     | Description                             |
| :--------  | :------- | :-------------------------              |
| `date`     | `date`   | the date the form created               |
| `payment`  | `int`    | amount of money to be payed             |
| `PhoneNum` | `string` | phonenum if service was mobile recharge |

submits the form that was created

#### addServiceProvider
```http
  POST {{LocalHost}}/Services/addServiceProvider
```
| Parameter  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `service`  | `string` | service name               |
| `provider` | `string` | service provider name      |

only admin can use this request, add new service provider for a service

# PAYMENT PACKAGE

#### pay
```http
  GET {{LocalHost}}/Payment/{{choice}}
```
pay for the last submited form(choice->1:wallet,2:creditcard,3:cash)

#### addCreditToWallet
```http
  PUT {{LocalHost}}/Payment
```
| Parameter  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `money`    | `int`    | amount of money            |

add money to wallet

# TRANSACTIONS PACKAGE

#### showServicetransactions
```http
  GET {{LocalHost}}/Transactions/ServiceTransactions 
```
gets all service transaction for the customer that is logged in

#### showWallettransactions
```http
  GET {{LocalHost}}/Transactions/WalletTransactions 
```
gets all Wallet transaction for the customer that is logged in

# RefundRequests PACKAGE

#### requestRefund
```http
  POST {{LocalHost}}/RefundRequest
```
| Parameter  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `id`       | `int`    | Transaction id             |

request refund on transaction with given id(used by customer)

#### showRequests
```http
  GET {{LocalHost}}/RefundRequest/viewRequests
```

#### AcceptRefund
```http
  PUT {{LocalHost}}/RefundRequest/accept
```
| Parameter  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `email`    | `string` | customer email             |
| `id`       | `int`    | request id                 |

#### RejectRefund
```http
  PUT {{LocalHost}}/RefundRequest/reject
```
| Parameter  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `email`    | `string` | customer email             |
| `id`       | `int`    | request id                 |

# DISCOUNTS PACKAGE

#### showDiscounts
```http
  GET {{LocalHost}}/Discount
```

#### CreateOverallDiscount
```http
  POST {{LocalHost}}/Discount/Overall
```
| Parameter     | Type     | Description                |
| :--------     | :------- | :------------------------- |
| `description` | `string` | discount description       |
| `percentage`  | `double` | discount percentage        |

#### CreateSpecificDiscount
```http
  POST {{LocalHost}}/Discount/Specific
```
| Parameter     | Type     | Description                |
| :--------     | :------- | :------------------------- |
| `service`     | `string` | service name               |
| `description` | `string` | discount description       |
| `percentage`  | `double` | discount percentage        |

#### DeleteDiscount
```http
  POST {{LocalHost}}/Discount/Delete
```
| Parameter     | Type     | Description                |
| :--------     | :------- | :------------------------- |
| `description` | `string` | discount description       |
| `percentage`  | `double` | discount percentage        |


## Running Tests

To run tests, u need to run the project in your IDE, then test using Postman
## Usage/Examples

here is an example on how a customer can choose a service and pay for it :)


```http
  POST {{LocalHost}}/Authentication/Login
    input
    {
      "email":"customer",
      "password":"customer"
    }

    output
       Log in Successfully
```
a customer must first login before any thing he does

```http
  GET {{LocalHost}}/Services

    output
       [
            "Internet Payment",
            "Landline Payment",
            "Donations",
            "Mobile Recharge"
        ]
```
Display all Services

```http
  POST {{LocalHost}}/Services/form
    input
    {
     "srvc":"Donations",
     "srvcprvdr":"Schools"
    }

    output
       {
         "date": null,
         "payment": 0.0,
         "phoneNumber": null
       }
```
an empty form will be created

```http
  POST {{LocalHost}}/Services/form
    input
    {
     "date": null,
     "payment":120,
     "phoneNumber": "01069408519"
    } 

    output
       Form Submitted Successfully
```
form filled

```http
  GET {{LocalHost}}/Payment/3
    
    output
       {
         "serviceAndProvider": "Donations Schools",
         "serviceID": 1,
         "cost": 120.0,
         "payment": "CashPayment",
         "done": true,
         "address": "1",
         "date": "2022-12-31T21:40:03.674+00:00"
        }
```
cash payment Successfull

```http
  GET {{LocalHost}}/Transactions/ServiceTransactions
    
    output
       {
         "serviceAndProvider": "Donations Schools",
         "serviceID": 1,
         "cost": 120.0,
         "payment": "CashPayment",
         "done": true,
         "address": "1",
         "date": "2022-12-31T21:40:03.674+00:00"
        }
```
display all customer Transactions