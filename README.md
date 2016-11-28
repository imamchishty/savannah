# Savannah : Service Versioning And History

Savannah keeps track of all API, build versions for services. 

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
