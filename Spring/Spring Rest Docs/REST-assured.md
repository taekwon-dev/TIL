# REST-assured

> Testing and validating REST services in Java in harder than in dynamic languages such as Ruby and Groovy. REST Assured brings the simplicity of using thiese languages into the Java domain. For exmple, if you HTTP server returns the following JSON at "http://localhost:8080/{id}":
>
> ```json
> {
>    "lotto":{
>       "lottoId":5,
>       "winning-numbers":[2,45,34,23,7,5,3],
>       "winners":[
>          {
>             "winnerId":23,
>             "numbers":[2,45,34,23,3,5]
>          },
>          {
>             "winnerId":54,
>             "numbers":[52,3,12,11,18,22]
>          }
>       ]
>    }
> }
> ```
>
> You can easily use REST Assured to validate interesting things from the response:
>
> ```java
> @Test public void
> lotto_resource_returns_200_with_expected_id_and_winners() {
> 
>     when().
>             get("/lotto/{id}", 5).
>     then().
>             statusCode(200).
>             body("lotto.lottoId", equalTo(5),
>                  "lotto.winners.winnerId", hasItems(23, 54));
> } 
> ```

### | Reference

###### https://rest-assured.io/