# Bankuish-Test


Bankuish
Android Code-Challenge

Context
Bankuish is a fintech company that uses application data for gig workers to create user financial
profiles taking into consideration their habits in these platforms and how they manage their
financial life. With this data analyzed, we go to the partner financial entities looking for banking
services that fit into the created profile, all of this through a mobile application.


<img width="643" alt="Screen Shot 2022-09-11 at 20 41 42" src="https://user-images.githubusercontent.com/53957022/189553884-bbee0633-d25a-48c9-9c4a-d84105122304.png">


Technical requisites
There are integrations through APIs and REST
There are integrations with CSVs files
We have a partner, which is a hub, to connect to these platforms online through REST APIs


Business needs
We want from you to create a sample App with the following requirements:
● Main Screen containing a list of Repositories from GitHub with Name and Author, only
showing those that match the criteria "language:kotlin"
● Once the user clicks any item on the list, it should Navigate to a second screen to
display Details about the Repository selected.
We work in a fast-paced environment with a constantly evolving product. Consider these
requirements would probably change and/or extend in a real-world scenario, and exercise
professional judgment while designing a Minimum Viable Product that should be flexible.
Tech specs
Desirable Implementations:
● Retrofit for Api call
● Gson for Parsing Response
● MVVM Architecture
● Navigation 
● Dependency Injection with Koin or Dagger
● Unit/Instrumented Tests
Optional Implementations (plus):
● Loading/Error State
● Pagination
● Swipe to Refresh

Api Specs:
URL: api.github.com/search/repositories (GET)
Params:
- q : Query Param | Sample : "language:kotlin"
- per_page : Amount of items per page | Sample: 30
- page : Current Page | Sample: 1
Example: https://api.github.com/search/repositories?q=kotlin&per_page=20&page=1



Techologyes applicated:
● Retrofit for Api call
● Gson for Parsing Response
● Clean architecture
● Jetpack compose
● Loading
● Swipe to Refresh
● Unit Tests
● Navigation with Compose
● Dependency Injection with Hilt compose
