# commons

This module contains common labs codebase, i.e. entities, DAOs, database access utilities, and also sample DB schema and data records.

### Table definition
```sql
CREATE TABLE cars (
    id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    make VARCHAR,
    model VARCHAR,
    color VARCHAR,
    clazz VARCHAR,
    right_hand VARCHAR,
);
```