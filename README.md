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

- To change the app name go to res/values/strings.xml then change the name inside the tage name    
 <string name="app_name">Your new name</string> .  (note : choose the structure type 'android' like the pic 1 ).
- To change the base url go to strings.xml like previous step then chanege the url inside the tage 
<string name="default_server_url">https://api.httpsms.com</string>
- To change the link in the main screen go to strings.xml like previous step then chanege the url inside the tage 
<string name="get_your_api_key">Open\nhttp://hypersender.com\nto get your API key</string>

