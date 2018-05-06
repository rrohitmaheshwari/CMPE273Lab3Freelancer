# CMPE273Lab3Freelancer
Freelancer prototype with ReactJS &amp; Springboot

Prototype of Freelancer Application

Freelancer Application Server- (to demonstrate RESTful Services) The next Springboot based server you need to develop is the “Prototype of Freelancerapplication”. This server should perform the following tasks:

a)Basic Users functionalities:

Sign up new user(Name, Email and password)
Sign in existing user
Sign out.
Profile (Profile Image, Name, Email, Phone Number, About Me, skills)
Users can update Profile anytime.Touse the system, a user must login first to the system.Password must be encrypted.
b)Post ProjectFunctionality: 1.All Users can post project as an employer (Project Title, Project Description, File Upload, SkillsRequired, Budget Range)

c)Home: 1.Users can seealist of all open projects. (ProjectName, Description, SkillsRequired, Employer, Budget Range, Numberof Bid yet,Bid Now)

d)Details View: 1.Project Details. (ProjectName, Description, Files, Skills, BudgetRange, Average Bid)

2.All userscanbid on the project. (Bid, Period in days)

3.List of All bids. (Profileimage, Freelancer Name, Bid Price, Periodin days, Hire Button only visible to employer of project)

e)Dashboard: 1.List of all projects you have bid on.(Project Name, Employer, Avg. Bid, your Bid, status of project) 2.List of all Projects you have published as employer. (Project Name, Average Bid, Freelancer Name, Estimate Project completionDate, status)

f) Should perform connection pooling (in-builtin mySql)for database access.

The Service should take care of exception that means validation is extremely important for this server. Properexception handling and prototype similar to actual Freelancer application would attract good marks.

Client - A client must include all the functionalities implemented by the web services. Develop the Client using HTML5 and ReactJS. A Simple, attractive and Responsive client attracts good marks.

Note: Every fieldinanentire project must have validation. User’s Name (Navigate to Profile) and Project Name (Navigate to ProjectDetails view)must have hyperlinks.

Testing of the server should be done using JMeter and Mocha.Mocha is a node.js testing framework. 1.Following tasks to be tested using JMeter: Test the serverfor 100, 200, 300, 400 and 500 concurrent users with and without connection pooling. Draw the graph with the average time and include it in the report.

2.Following tasks to be tested using Mocha: Implement fiverandomly selected REST web serviceAPI calls using Mocha. Display the output in the report.
