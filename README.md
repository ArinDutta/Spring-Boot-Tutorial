# Spring-Boot-Tutorial
The goal of this projects is to implement properties file driven Spring Security.


Properties Files:- 
users={"arin":"password","john":"password2","Lura":"password"} 
usersroles={"arin":"DEVELOPER,ADMIN","john":"ADMIN","Lura":"DEVELOPER"}

REST URL :-
/welcome       --> This URL doesn't need any security.
/description   --> he user with role DEVELOPER can only access this URL.
/actuator      --> he user with role ADMIN can only access this URL. 




