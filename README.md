OrderEase

features 
- Full CRUD operations for orders, invoices, products, and customers
-  Modular Java architecture with DAO, service, and model layers
-  Oracle SQL integration via JDBC
- Auto-increment IDs using sequences and triggers
-  Console-based UI for interaction
-  Clean separation of concerns and reusable components

Setup Instructions

1. Clone the repo  
   `git clone https://github.com/arunnaik0110/OrderEase.git`
2. Set up Oracle DB and run `schema.sql`, `sequences.sql`, and `triggers.sql`
3. Configure JDBC connection in `DBConfig.java`
4. Run `Main.java` to start the app

Notes

- Ensure Oracle listener is running and SID is correctly configured
- Troubleshooting tips for JDBC and Oracle quirks are documented in `/docs`

