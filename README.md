# Savannah : Service Versioning And History

Microservices don't exist without other services. Sooner or later you'll end up with lots services all interacting with each other.
Keeping tabs on them isn't something that you usually think of when you get started. But eventually you'll need to. Which version of Service A is running in qa right now? What about Service A in production? Does Service B 1.0 work with Service A in qa? Can I see the historical view and the service dependencies? This is where Savannah comes in!

Savannah keeps track of all API, build versions for services. 

## How?
Savannah is a rest API and keeps its records in a persistence layer (your choice). As it supports multiple environments/profile you don't need to have an instance of Savannah for each target, e.g. QA, Prod. 

One simple way to notify Savannah of new versions of a service could be via the `@SavannahClient` annotation or via your CI pipeline (when you deploy your app you call the Savannah API).

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
