## Run migration database
- First open dbeaver/pgadmin
- create new database library (follow in application.yml)
- copy and paste file sql in resource/db.migration
- done

## How to run the code
- type in terminal  mvn clean install
- mvn spring-boot:run
- open postman http://localhost:8080/api/books (add book)
- done

## APIS
- book `add book`
- borrower `add borrower`
- borrow history `history to borrow and return`
- done

`postman collection will be place it in postman directory`
