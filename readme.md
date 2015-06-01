Login

curl -i -X POST -d username=user -d password=password -c ./cookies.txt http://localhost:8080/login

Create Country
 
curl -i -X POST -H "Content-Type:application/json" -b ./cookies.txt -d '{  "code" : "tn",  "populationCount" : 12000 ,  "capitalName" : "Tunis" ,  "countryName" : "Tunisia" ,  "languageCode" : "en"   }' http://localhost:8080/api/rest/countries/save

Add Translation

 curl -i -X POST -H "Content-Type:application/json" -b ./cookies.txt -d '{"name": "Tunisie","capitalName" : "Tunis" , "country":{"id":1}, "language":{"id":2}}' http://localhost:8080/api/rest/countries/add_translation

Get country with all the languages names

curl -i -X GET -H "Content-Type:application/json" -b ./cookies.txt http://localhost:8080/api/rest/countries/get/tn?val=all

Get country with default language name.

curl -i -X GET -H "Content-Type:application/json" -b ./cookies.txt http://localhost:8080/api/rest/countries/get/tn

Repositories crud

curl -i -X GET -H "Content-Type:application/json"  -b ./cookies.txt http://localhost:8080/api/rest/language

curl -i -X GET -H "Content-Type:application/json"  -b ./cookies.txt http://localhost:8080/api/rest/countryln

curl -i -X GET -H "Content-Type:application/json"  -b ./cookies.txt http://localhost:8080/api/rest/country





