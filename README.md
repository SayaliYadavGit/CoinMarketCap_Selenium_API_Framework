# CoinMarketCap_Selenium_API_Framework
End to End framework using Restassured | Cucumber BDD |Java | Selenium which covers the Backend and Frontend scenarios for CoinMarketCap website

Prerequisites to run:
-Clone the project
-All the dependencies should be downloaded and should be in sync

System Prerequisites: Maven, Java

Feature file coverage:
![image](https://user-images.githubusercontent.com/118114531/201904799-a24a30cf-6ef1-4dcd-8ed4-2b6a27af9c0d.png)
![image](https://user-images.githubusercontent.com/118114531/201904818-c180a9d4-4188-4a63-83a1-6055a73f9387.png)

Steps to execute the test:
1. Run as junit test

2. Click on src/test/java/runners/TestRunner.java

3. Click Run

![image](https://user-images.githubusercontent.com/118114531/201904942-47995f5e-ef09-4e19-9923-d8d24026fdfa.png)
Reports will available at folder : target/reports. Below is screenshot of sample report 
![image](https://user-images.githubusercontent.com/118114531/201905013-9afd91e8-0721-431a-bda0-6a98df5c992f.png)
1 test case failed as actual output did'nt match the expected output

Test case - Confirm that the currency ETH has the mineable tag associated with it: "tags": [ "mineable" ]
Actual Response related to tags for currency ETH: "tags":["pos","smart-contracts","ethereum-ecosystem","coinbase-ventures-portfolio","three-arrows-capital-portfolio","polychain-capital-portfolio","binance-labs-portfolio","blockchain-capital-portfolio","boostvc-portfolio","cms-holdings-portfolio","dcg-portfolio","dragonfly-capital-portfolio","electric-capital-portfolio","fabric-ventures-portfolio","framework-ventures-portfolio","hashkey-capital-portfolio","kenetic-capital-portfolio","huobi-capital-portfolio","alameda-research-portfolio","a16z-portfolio","1confirmation-portfolio","winklevoss-capital-portfolio","usv-portfolio","placeholder-ventures-portfolio","pantera-capital-portfolio","multicoin-capital-portfolio","paradigm-portfolio","injective-ecosystem"] Since this tag does't have mineable the test failed
