# PatientTopApplication

Cucumber based framework is used

Model - Page object

Cucumber native reporting is added in runner file

->Re-usables code has generic selenium actions

->Test folder has all the Page objects , Runner file , stepdefinition

->src/test/resources has the feature file which is the test case - The Manual scenarios is added in the same feature itself with comment as #Manual scenarios

->env is the environment parament to pass the url 
Ex: mvn test --ENV="https://compare-staging.patientpop.com/checkup"