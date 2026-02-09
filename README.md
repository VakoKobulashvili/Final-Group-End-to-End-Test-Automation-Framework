# End-to-End Test Automation Framework

## Group Members

| Member | Role | Responsibilities |
|--------|------|------------------|
| **Saba Kublashvili**  UI Test Cases 1-4, 6 |
| **Vako Kobulashvili** UI Test Cases 7-11 |
| **Luka Gachechiladze** API Test Cases 1, 3, 5, 7, 11 |
| **Anri Ugrekhelidze** API Test Cases 2, 4, 6, 8, 10 |

## Test Case Mapping

### UI Test Cases

#### Saba Kublashvili (Member A)
- ✅ **Test Case 1** – Register User (`RegisterUserTest1.java`)
- ✅ **Test Case 2** – Login User with correct email and password (`LoginUserCorrectTest2.java`)
- ✅ **Test Case 3** – Login User with incorrect email and password (`LoginUserIncorrectTest3.java`)
- ✅ **Test Case 4** – Logout User (`LogoutUserTest4.java`)
- ✅ **Test Case 6** – Contact Us Form (`ContactUsFormTest6.java`)

#### Vako Kobulashvili (Member B)
- ✅ **Test Case 7** – Verify Test Cases Page (`VerifyTestCasesPageTest7.java`)
- ✅ **Test Case 8** – Verify All Products and Product Detail Page (`VerifyAllProductsAndDetailTest8.java`)
- ✅ **Test Case 9** – Search Product (`SearchProductTest9.java`)
- ✅ **Test Case 10** – Verify Subscription in Home Page (`VerifySubscriptionHomeTest10.java`)
- ✅ **Test Case 11** – Verify Subscription in Cart Page (`VerifySubscriptionCartTest11.java`)

### API Test Cases

#### Luka Gachechiladze (Member C)
- ✅ **API 1** – Get All Products List (`GetAllProductsApiTest1.java`)
- ✅ **API 3** – Get All Brands List (`GetAllBrandsApiTest3.java`)
- ✅ **API 5** – POST To Search Product (`SearchProductApiTest5.java`)
- ✅ **API 7** – POST To Verify Login with valid details (`VerifyLoginApiTest7.java`)
- ✅ **API 11** – POST To Create/Register User Account (`RegisterUserApiTest11.java`)

#### Anri Ugrekhelidze (Member D)
- ✅ **API 2** – POST To All Products List (`PostAllProductsApiTest2.java`)
- ✅ **API 4** – PUT To All Brands List (`PutAllBrandsApiTest4.java`)
- ✅ **API 6** – POST To Search Product without search_product parameter (`SearchProductWithoutParamApiTest6.java`)
- ✅ **API 8** – POST To Verify Login without email parameter (`VerifyLoginWithoutEmailApiTest8.java`)
- ✅ **API 10** – POST To Verify Login with invalid details (`VerifyLoginInvalidDetailsApiTest10.java`)


### Run Tests in Parallel

The framework is configured for parallel execution. Tests run in parallel by default using TestNG's parallel execution feature (configured in `testng.xml`).

generate and open report:
```bash
allure serve target/allure-results
```


