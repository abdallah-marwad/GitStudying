# Hypersender SmS

- To change the applicationId from android studio go to build.gradle (module:app) (note : choose the structure type 'android' like the pic 1 ).
then change applicationId "com.hypersender.sms" to be any name you need like applicationId "com.anyname.youneed" the from the top right of screen 
its syncnow like in pic 2 click on it and wait for it finish.
(you successfully change the applicationId .)

**pic 1 *
<div>
   <img src ="https://github.com/abdallah-marwad/E-Commerce_Application/assets/115652759/62e42a1c-c77d-4285-98a3-f255712efbcf" width="200" >
</div>

**pic 2 *
<div>
   <img src ="https://github.com/abdallah-marwad/E-Commerce_Application/assets/115652759/6444e6eb-ee60-4ad5-9ea4-be3b11e94d11" width="200" >
</div>

- There is one step left to make new firebase project and enable cloud messaging 
then from the setting of firebase console choose add app and select android then type the name of applicationId 
then download the google-services.json that appear after the previous step 
and put it instead of the existing one like pic 3 
**pic 3 *
<div>
   <img src ="https://github.com/abdallah-marwad/E-Commerce_Application/assets/115652759/7817c61c-feba-4caf-b33c-90500294830c" width="200" >
</div>
- To get signed AAB that is sharable on google play follow this link : https://youtu.be/QqQ83qK6_rk?si=DozhpQA5vhmCo2cV
(note : sure that you select at the first Android App Bundel not apk)

- To change the app name go to res/values/strings.xml then change the name inside the tag name="app_name" .  (note : choose the structure type 'android' like the pic 1 ).
- To change the base url go to strings.xml like previous step then chanege the url inside the tag name="default_server_url"
- To change the link in the main screen go to strings.xml like previous step then chanege the url inside the tag name="get_your_api_key"
- To change the app pic go to drawable/logo_cropped delete this image and add new one by drag and drop,the new one must be the same name (logo_cropped)
then follow this video : https://www.youtube.com/watch?v=bJjHgWjiAKw

---
** The changes done in the project **

- Make the visibilty = gone  for Encription Key inside activity_settings

- Make the SIM2 is optianal by adding this line if (phoneNumberSIM2.text.toString().isNotEmpty()) at 177 line in LoginActivity
and also add this &&phoneNumberSIM2.text.toString().isNotEmpty() in line 232

- Make url not required as https by comment the code in line 201 in LoginActivity and add this line inside Manifist.xml
 android:usesCleartextTraffic="true"

- To change links go to string.xml and replace any url with new one 

- Inside the build.gradle(module : app) i replace versionName : "${getGitHash()}" to be versionName : "1.0" becouse it get some data 
about my windows and it make crash at the runtime 

- adding new field to change api key inside activity_settings and attach its logic inside SettingActivity with 2 fun 
1-changeApiKey() 
2- removeErrFromEd(param1 , param2)

- Make sure that Heartbeat send to the server repeatily every 15 min and testing it called auto inside MAinActivity
with fun scheduleHeartbeatWorker(this) this called once the screan is created whether the heartbeat btn clicked or not .

- add localTime and batteryPercentage to HttpSmsApiService calss inside the function with name of : storeHeartbeat ()
and make it called instead of the old one.



