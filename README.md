# Savannah (Service API Versioning And History)

Microservices don't exist without other services. Sooner or later you'll end up with lots services all interacting with each other.
Keeping tabs on them isn't something that you usually think of when you get started. But eventually you'll need to. Which version of Service A is running in qa right now? What about Service A in production? Does Service B 1.0 work with Service A in qa? Can I see the historical view and the service dependencies? This is where Savannah comes in!

Savannah keeps track of all API, build versions for services. 

## What?
Savannah is a Server (with an API) that stores metadata about all of your services and profiles (environments e.g. qa, test). By default these 'records' are kept in memory but Savannah allow you to persist these however you feel best. The following diagram shows how it works from a high-level:

![alt tag](https://github.com/imamchishty/savannah/blob/master/docs/savannah1.png)

## Part of a pipeline

![alt tag](https://github.com/imamchishty/savannah/blob/master/docs/savannah-pipeline-detail.png)

## Benefits

Some quick benefits:
  1. Central view of all services and their associated versions.
  2. Can easily map out service hierarchy (most critical services etc).
  3. Search for services and see where they're available (only at profile/env level).
  4. Historical records.
  5. Dependencies of all services, easy to see ordered deployments

## Sample JSON
```
  {
      "services": [
          {
              "service": "serviceA",
              "description": "calculates interest",
              "metadata": [
                  {
                      "team": "dubai1"
                  },
                  {
                      "wiki": "serviceA.wiki.com"
                  }
              ]
              "profiles": [
                  {
                      "profile": "dev",
                      "build": "1.1.0.b12",
                      "dateTime": "12:12:29 29/11/2016"
                      "api": [
                          "1.0",
                          "1.1"
                      ],
                      "dependencies": [
                          {
                              "service": "serviceB",
                              "api": [
                                  "1.2"
                              ]
                          },
                          {
                              "service": "serviceC"
                          }
                      ]
                  },
                  {
                      "profile": "test",
                      "build": "1.1.0.b7",
                      "dateTime": "17:06:18 21/11/2016"
                      "api": [
                          "1.0",
                          "1.1"
                      ],
                      "dependencies": [
                          {
                              "service": "serviceB",
                              "api": [
                                  "1.1"
                              ]
                          },
                          {
                              "service": "serviceC"
                          }
                      ]
                  },
                  {
                      "profile": "prod",
                      "build": "1.0.0.b89",
                      "dateTime": "19:26:48 02/11/2016"
                      "api": [
                          "1.0",
                          "1.1"
                      ],
                      "dependencies": [
                          {
                              "service": "serviceB",
                              "api": [
                                  "1.0"
                              ]
                          },
                          {
                              "service": "serviceC"
                          }
                      ]
                  }
              ]
          }
      ]
  }
```


## API
Rest API

### /savannah/api/apps
Returns a list of all registered apps.

### /savannah/api/apps/{appId}
Returns all profiles for the app, e.g. production, qa etc.

### /savannah/api/apps/{appId}/{profile}
Returns the selected apss profile details.

### /savannah/api/apps{appId}/history
Returns a historical view of the versions for the given app.

### /savannah/api/apps/{appId}/{profile}/history
Returns a historical view for the given profile.

### /savannah/api/{appId}/{profile}/dependencies
Returns a list of service depedencies that this app+profile has.

## UI
Visual view of the API

### /savannah/ui/apps
Returns a list of all registered apps.

### /savannah/ui/apps/{appId}
Returns all profiles for the app, e.g. production, qa etc.

### /savannah/ui/apps/{appId}/{profile}
Returns the selected apss profile details.

### /savannah/ui/apps{appId}/history
Returns a historical view of the versions for the given app.

### /savannah/ui/apps/{appId}/{profile}/history
Returns a historical view for the given profile.

### /savannah/ui/{appId}/{profile}/dependencies
Returns a list of service depedencies that this app+profile has.
