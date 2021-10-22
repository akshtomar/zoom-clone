App name- zoom clone App.

SDK used - openVidu <br>
SDK version - 2.18.0 <br> 
source - https://openvidu.io/index <br>

Project Structure

![An image](https://docs.google.com/uc?id=0B61cQ4sbhmWSQzJGRDhzS1dNZFk)



OpenVidu is composed by the modules displayed on the image above.

**openvidu-browser:** JavaScript library for the browser. It allows you to manage your video-calls straight away from your clients    <br>
**openvidu-java-client:** server SDK for Java. Quick alternative to REST API   <br>
**openvidu-server:** application to control Kurento Media Server          <br>
**Kurento Media Server:** handles low level operations of media flow transmissions <br>


Reference- https://docs.openvidu.io/en/2.18.0/tutorials/openvidu-mvc-java/


Method of execution of program (server)-
1. Run this maven project
2. OpenVidu Platform service must be up and running - (https://docs.openvidu.io/en/2.18.0/reference-docs/REST-API/)- 

 sudo docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET openvidu/openvidu-server-kms:2.18.0

 this will start OpenVidu server so that our maven project can connect with api using
 OpenVidu Server URL: https://localhost:4443 (which consume REST API in this URL)

All of the REST API operations exposed by OpenVidu Server...

Share the same base path /openvidu/api/                         (Internally taken care by SDK)

Share the same Authorization header. It is implemented via Basic Auth, and it is as simple as applying Base64 encoding to the username (always "OPENVIDUAPP") and the password (configuration propertyOPENVIDU_SECRET). 

All REST API operations return HTTP status 401 if the Authorization header is wrong or not provided. For example, for secret "MY_SECRET" the final HTTP header would be:

**Authorization: Basic T1BFTlZJRFVBUFA6TVlfU0VDUkVU**

Note- To run openVidu server in differnet location other than localhost

**-e DOMAIN_OR_PUBLIC_IP=Your_ip_address**   in the url of docker


**Important Links -**
1. Rest API - https://docs.openvidu.io/en/2.18.0/reference-docs/REST-API/
2. MVC java - https://docs.openvidu.io/en/2.18.0/tutorials/openvidu-mvc-java/
3. openvidu-java-client java package details - https://docs.openvidu.io/en/2.18.0/api/openvidu-java-client/io/openvidu/java/client/package-summary.html
4. openvidu-config -  https://docs.openvidu.io/en/2.18.0/reference-docs/openvidu-config/
5. openvidu classes - https://docs.openvidu.io/en/2.18.0/api/openvidu-browser/classes/openvidu.html







