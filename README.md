# TDDWebServer 
 
An HTTP server written in Java.  98% Test Driven.

## CORE
This server was created to handle http requests such as get, put, post, option and delete. 
You can find that functionality at `TDDWebServer/src/javax/com/lallen/javaserver/core`.   

## COB SPEC
This server also comes packaged with the functionality to handle Cob Spec requests, such as properly displaying partials based on range, decoding parameters, displaying fun gifs on screen, and more.
You can find the Cob Spec handlers at  `TDDWebServer/src/javax/com/lallen/javaserver/cobspec`.
 
## REQUIREMENTS
  * Java "1.7.0_04"
  * [Cob Spec]: https://github.com/8thlight/cob_spec
 
## RUNNING THE SERVER
  * Start the server with `java -jar build/libs/javaServer.jar -p 5000 -d PATH/TO/COB_SPEC/PUBLIC`

## RUNNING THE TESTS
 * Currently, I use Intellij to run the tests.

## RUNNING COB SPEC 
  1. Make sure that CobSpec is located in the same directory as your sever.  For example, if your have placed the       server in `Users/projects/ohLookHereIsMyAwesomeServer`, then cob spec should be in `User/projects/cobSpec`.
  2. Run `java -jar fitnesse.jar -p 9090`.
  3. Navigate to LocalHost:9090.
