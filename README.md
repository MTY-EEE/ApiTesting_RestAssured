# TMDB API Test Automation

This project performs automated testing of [The Movie Database (TMDB)](https://api.themoviedb.org) RESTful API using **Java** and the **Rest Assured** framework. It is designed to verify that various API endpoints return correct and expected responses.

---

## 🚀 Project Purpose

The main goal of this project is to test whether the RESTful API endpoints provided by TMDB are working correctly and returning the expected results. Since APIs are widely used to transfer data between systems or provide services to developers, ensuring their reliability, accuracy, and stability is crucial.

This project aims to:

- ✅ Verify the responses of TMDB API endpoints based on **HTTP status codes**, **response bodies**, and **headers**  
- ❌ Test **positive and negative scenarios** to evaluate how the API handles valid and invalid requests  
- 🔎 Ensure that the returned data is in the correct structure and includes all expected fields  
- 🔧 Analyze how different parameters (e.g., API key, query strings) affect the API behavior  
- 🤖 Automate the test scenarios for **repeatability**, **reliability**, and **maintainability**  

This project is particularly useful for backend developers and QA engineers who want a practical and hands-on example of automated REST API testing using Java and Rest Assured.

---

## 💻 System Requirements

| Requirement     | Version / Description                  |
|-----------------|----------------------------------------|
| Java JDK        | 11 or later                            |
| Maven           | 3.6+                                   |
| IDE (optional)  | IntelliJ IDEA, Eclipse, or VS Code     |
| Internet Access | Required for making live API requests  |
| API Key         | Obtainable from [TMDB](https://www.themoviedb.org/) |

---

## 📁 Project Structure

```bash
tmdb-api-test/
├── pom.xml                       # Maven build configuration
├── README.md                     # Project documentation
└── src/
    └── test/
        ├── java/
        │   ├── 01_Account/            # Test classes
        |   ├── 02_Genres/            # Test classes
        |   ├── 03_MovieList/            # Test classes
        |   ├── 04_Search/            # Test classes
        |   ├── 05_Movies/            # Test classes
        │   └── utility/          # # API key and base URL settings
        └── resources/

 ```      
---
## 📊 Test Coverage
The project includes tests for the following endpoints:

- ```GET /movie/popular```

- ```GET /movie/{movie_id}```

- ```GET /search/movie?query=```

- ```GET /genre/movie/list```

- ```GET /movie/top_rated```

Test types implemented:

- ✅ Positive Tests

- ❌ Negative Tests (invalid API key, missing parameters)

- 🔒 Authorization Tests

- ⏱ Basic Performance Checks

---

## 👨‍💻 Contributors
| Name                     | Role                 | GitHub                                                |
|--------------------------|----------------------|-------------------------------------------------------|
| **Serkan Sewöster**      | Team Lead / PO       | [SerkanSewoester](https://github.com/SerkanSewoester) |
| **Ennur Göl**            | QA Automation Tester | [ennur7](https://github.com/ennur7)                   |
| **Burak Bora Durmaz**    | QA Automation Tester | [burakboradurmaz](https://github.com/burakboradurmaz) |
| **Ayşenur Can**          | QA Automation Tester | [aysenur-g-c](https://github.com/aysenur-g-c)         |
| **İbrahim Can**          | QA Automation Tester | [ibcan9](https://github.com/ibcan9)                   |
| **Hakan Mert**           | QA Automation Tester | [hakan-mert](https://github.com/hakan-mert)           |
| **Murat Öksüz**          | QA Automation Tester | [muratoksuz](https://github.com/muratoksuz)           |
| **Tuğba Yılmaz**         | QA Automation Tester | [MTY-EEE](https://github.com/MTY-EEE)                 |
