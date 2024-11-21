Here's an updated README based on the technologies you've mentioned:

---

# Account Aggregator Application

This is an Account Aggregator Application that enables users to consolidate their financial data from multiple sources, providing a unified interface to view and manage financial information across various accounts such as bank accounts, loans, and investments.

## Features

- **Data Aggregation**: Integrate and display data from different accounts in one place.
- **Unified Dashboard**: Get insights and detailed views on various financial accounts.
- **Authentication**: Secure login system using JWT tokens.
- **User Profile**: Manage and update personal and account details.
- **Data Synchronization**: Regular updates to keep account data current.
- **Alerts & Notifications**: Receive alerts about critical account activities.

## Technologies Used

- **Frontend**: Angular, Angular Material
- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Tokens)
- **Version Control**: Git, GitHub

## Installation

To run this application locally, follow the steps below:

### 1. Clone the repository:
```bash
git clone https://github.com/yourusername/account-aggregator.git
cd account-aggregator
```

### 2. Install dependencies:
- **Frontend**:
    ```bash
    cd frontend
    npm install
    ```
- **Backend**:
    ```bash
    cd backend
    ./mvnw install
    ```

### 3. Set up environment variables:
Create a `.env` file in the root directory and set up the necessary environment variables such as API keys, database connection strings, JWT secret key, etc.

### 4. Run the application:
- **Frontend**:
    ```bash
    ng serve
    ```
- **Backend**:
    ```bash
    ./mvnw spring-boot:run
    ```

## Usage

1. Open the application in your browser (default is `http://localhost:4200` for the frontend).
2. Register or log in using your credentials.
3. Link your financial accounts (e.g., banks, investments) via API integration options.
4. View aggregated data and insights on your dashboard.

## Contributing

Feel free to fork the project and submit pull requests. To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a pull request.
