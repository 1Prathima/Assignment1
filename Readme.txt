#Spring Boot Project

## Project Description
This is a Spring Boot application that provides APIs to manage employee data. It uses MongoDB as the database for storing employee information.

## Prerequisites
- Java JDK 11 or later installed
- Apache Maven installed
- MongoDB installed and running on default host and port (localhost:27017)

## Setup Instructions
1. Clone the repository: https://github.com/1Prathima/Assignment1
2. Navigate to the project root directory
3. Run the application


## Database Setup
- This project uses MongoDB for data storage.
- Ensure MongoDB is installed and running on default host and port (localhost:27017).
- No additional setup is required as Spring Boot automatically connects to MongoDB with default settings.

## API Endpoints

### Create Employee
- Endpoint: `/employee/add`
- Method: POST
- Description: Create a new employee.
- Request:
{
    "employeeName":"XYZ",
    "phoneNumber":"8971226912",
    "email":"xyz@gmail.com",
    "reportsTo":"f97ca45f-f621-448e-aacd-e64b6ce0f526",
    "profileImage":"https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
}
- Response:
"15bfb6d7-ae61-4dd4-885f-9485856464f4"
Response is the generated UUID of the employee.

### Get All Employees
- Endpoint: `/employee/getAll`
- Method: GET
- Description: Retrieve a list of all employees.
- Response:
[
    {
        "id": "518da774-acd7-484f-8166-ef5925e18e77",
        "employeeName": "Prathima",
        "phoneNumber": "8971226911",
        "email": "Prat@gmail.com",
        "reportsTo": null,
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    },
    {
        "id": "c5e2e580-9438-44f0-b76c-d605bed615af",
        "employeeName": "Priyanka",
        "phoneNumber": "123456789",
        "email": "Priya@gmail.com",
        "reportsTo": "c4a7d73b-6896-46ec-9b41-0170dbf5cb23",
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    },
    {
        "id": "c4a7d73b-6896-46ec-9b41-0170dbf5cb23",
        "employeeName": "Shruti",
        "phoneNumber": "234567891",
        "email": "shruti@gmail.com",
        "reportsTo": "77e3c6f4-acda-4084-82a1-ce80ec828ad2",
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    },
    {
        "id": "77e3c6f4-acda-4084-82a1-ce80ec828ad2",
        "employeeName": "Jyoti",
        "phoneNumber": "345678910",
        "email": "jyoti@gmail.com",
        "reportsTo": "518da774-acd7-484f-8166-ef5925e18e77",
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    },
    {
        "id": "f97ca45f-f621-448e-aacd-e64b6ce0f526",
        "employeeName": "ABC",
        "phoneNumber": "8971226999",
        "email": "banasodeprathima5.pb@gmail.com",
        "reportsTo": null,
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    },
    {
        "id": "15bfb6d7-ae61-4dd4-885f-9485856464f4",
        "employeeName": "XYZ",
        "phoneNumber": "8971226912",
        "email": "xyz@gmail.com",
        "reportsTo": "f97ca45f-f621-448e-aacd-e64b6ce0f526",
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    }
]

### Delete Employee
- Endpoint: `/employee/delete`
- Method: DELETE
- Description: Delete an employee by ID.
- Request:
{
    "id":"27dee2be-08f7-4aa6-a0aa-e9e2339ce45e"
}
- Response:
"Employee deleted successfully"



### Update Employee
- Endpoint: `/employee/update`
- Method: PUT
- Description: Update an existing employee.
- Request:
{
       "id": "77e3c6f4-acda-4084-82a1-ce80ec828ad2",
        "employeeName": "Jyoti",
        "phoneNumber": "345678910",
        "email": "jyoti@gmail.com",
        "reportsTo": "518da774-acd7-484f-8166-ef5925e18e77",
        "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
    }
- Response:
"Employee has been updated successfully"

### Update Employee
- Endpoint: `/employee/getManager`
- Method: GET
- Description: Retrieve nth level manager.
- Request:
{
    "employeeId":"c5e2e580-9438-44f0-b76c-d605bed615af",
    "n":2
}
- Response:
{
    "id": "77e3c6f4-acda-4084-82a1-ce80ec828ad2",
    "employeeName": "Jyoti",
    "phoneNumber": "345678910",
    "email": "jyoti@gmail.com",
    "reportsTo": "518da774-acd7-484f-8166-ef5925e18e77",
    "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemint.com%2Fnews%2Findia%2Fnew-study-says-cats-are-dangerous-cat-lovers-react-11659326157324.html&psig=AOvVaw2fMFXXSx-DxO5y21MzH0f4&ust=1690315621519000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCi1piSqIADFQAAAAAdAAAAABAE"
}


## Additional Notes
- This project is for demonstration purposes only and may not be suitable for production use.
- For more details, refer to the source code and comments in the project.
- If you encounter any issues or have questions, please open an issue on the GitHub repository.

Happy coding! :)





