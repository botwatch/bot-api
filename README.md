# Botwat.ch Java 8 Integration
A superiorly crafted java 8 library for interfacing with the botwatch backend service. A note: all methods have the ability to return null if they have failed. Future support is planned to instead throw specific exceptions.

## Users
#### Creation
```User user = Users.create("user", "email@google.com", "password");```

- The above will provide a user data object. You may store the token for future authentication, or continue to use the password.
- The api will cache the result and automatically provide the authorization headers throughout the rest of the application's lifetime.
#### Login (token)
```User user = Users.login("user", token);```
#### Authenticate (password)
```User user = Users.create("user", "password");```
## Accounts
#### Creation
```OldSchoolAccount account = Accounts.create("account alias");```
- The above account will be created, using the authorization headers to identify the _User_ whom it belongs to. The data object for the account will be returned on success.
## Clients
#### Creation
```BotClient client = Clients.create("name", "description", "website", "author1,author2");```
- Unlike the others, the client will not be attributed to the User who created it, but rather the authors If they exist as Users.
## Sessions
#### Creation
```Session session = Sessions.create(client.name, acc.alias);```
- The session will be created and returned, using the authorization headers to identify the _User_ whom it belongs to. 
- User must have ownership of the account alias specified, client must be a valid and existent client name.
- Sessions will automatically be ended after 10 minutes with no activity and a new session must be created.
## Experience
#### Creation
```Experiences.create(skillIndex, skillExperience, session.id);```
- Skill Index is the index of a skill in runescape from 0 to 26.
- Skill Experience is the total experience the account holds in this skill index.
- Session Id must be provided and active.
## Interaction
#### Creation
```Interactions.create(int param1, int param2, int param3, int identifier, int menuOption, int menuTarget, int mouseX, int mouseY, int locationX, int locationY, session.id);```
- To be explained later...
- Session Id must be provided and active.
