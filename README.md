# WebServer 
 
An HTTP server written in Java.  98% Test Driven.

## CORE
This server was created to handle http requests such as get, put, post, option and delete. 
You can find that functionality at `TDDWebServer/src/javax/com/lallen/javaserver/core`.   

## COBSPEC
This server also comes packaged with the functionality to handle cobSpec requests, such as properly displaying partials based on range, decoding parameters, displaying fun gifs on screen, and more.
You can find the cobSpec handlers at  `TDDWebServer/src/javax/com/lallen/javaserver/cobspec`.
 
## Requirements
  * Java "1.7.0_04"
  * [Cob Spec]: https://github.com/8thlight/cob_spec
 
## Running the server
  * Start the server with `java -jar build/libs/javaServer.jar -p 5000 -d PATH/TO/COB_SPEC/PUBLIC`

## Running the tests
 * Currently, I use Intellij to run the tests.

## Running Cob Spec : 3 Simple Steps
  1. Make sure that Cob Spec is located in the same directory as your sever.  For example, if your have placed the       server in `Users/projects/ohLookHereIsMyAwesomeServer`, then cob spec should be in `User/projects/cobSpec`
  2. Run `java -jar fitnesse.jar -p 9090`
  3. Navigate to LocalHost:9090
