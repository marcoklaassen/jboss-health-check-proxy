# JBoss Health Check Proxy

If you want to expose the health check for JBoss EAP, you have to expose the management api. 
Exposing the management API completely may be a security issue. 

This application is a proxy to the ````localhost:9990/health```` endpoint. 
After the deployment of this application, you are able to reach the health check endpoint 
via ```http[s]://<yourdomain>/health-proxy/rest/health```.

Now you don't have to make your JBoss management API public,
but you are able to provide the health check endpoint via the application's route and default port.  

## Build and deploy the application

To build the app use 
```
mvn clean package
```

and then copy the 

```
target/health-proxy.war
```

to your JBoss deployment directory (in my case: `/opt/eap/standalone/deployments/`).

If the application deployment was successfully, you should see something like: 

```json
[
  {
    "name" : "server-state", 
    "outcome" : true, 
    "data" : [
      { "value" : "running" }
    ]
  },
  {"name" : "deployments-status", 
    "outcome" : true, 
    "data" : [
      { 
        "ROOT.war" : "OK"
      },
      {
        "health-proxy.war" : "OK"
      }
    ]
  },
  {
    "name" : "boot-errors", 
    "outcome" : true
  },
  {
    "name" : "live-server", 
    "outcome" : true
  },
  { 
    "outcome" : true
  }
]
```