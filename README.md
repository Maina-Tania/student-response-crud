# student-response-crud
This is a simple CRUD application that uses an EntityResponse class, a custom response wrapper that standardizes the format of responses returned by the service methods in the CRUD application. 

##Key Features:

Student Registration: Create new student records by sending a POST request to the appropriate endpoint, providing the necessary details such as name, email, and academic information.

Student Retrieval: Retrieve a list of all registered students or fetch details of a specific student by sending a GET request with the appropriate endpoint and parameters.

Student Update: Modify existing student records by sending a PUT request with the updated data and the corresponding student ID.

Student Deletion: Remove student records from the system by sending a DELETE request with the student ID.

Standardized Responses: All API responses are wrapped in the custom EntityResponse class, providing a consistent and predictable structure for clients to handle.

Error Handling: Comprehensive error handling mechanisms are in place, ensuring that clients receive clear and informative error messages when encountering issues.
