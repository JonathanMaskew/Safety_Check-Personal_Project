# Safety Check - Personal Project

## General Overview
Live alone or know someone that does and you worry about your/their health and safety? This prgroam helps to reduce those worries by allowing an individual to check in daily. If the user does not check in by a specified time, an alert is sent to the phone numbers the user specified.

### Purpose of Program
Many individuals, including my Grandma, live alone on a daily basis. Whether the individual has a health concern, is aging, or is just concerned for their safety, this program is meant to help relieve those anxieties by allowing the individual to check in daily. Individuals can live comforted knowing that if the user does not check in by a specified time, those numbers provided will be contacted to check on them and get help as needed. If an individual has a concern that doesn't warrant emergency personnel, the individual is also able to request immediate assisstance to immediately contact those numbers specified, and add a note of what the concern is.Overall, the purpose is to allow individuals, families, and friends to feel more comforted knowing that someone will be there to check on them and get the assisstance that they need.

### What I Learned
I learned many new things in creating this project. Firstly, I learned how to use a new API, the JavaMail API. This was my first time using the JavaMail API as well as the JavaBeans Activation Framework. I also learned that most cellular companies have an email address that when emailed, send a text to the specified phone number. This, combined with the JavaMail API, is what allowed me to send text alerts to the numbers the individual specified. This is also only my second time using  LocalDateTime, so I continued to learn how I can use it even further, allowing my program to react based on real-world dates and times.

### Features
- 

## Class Overview
### SafetyCheck.java


## What can be Improved in the Future?
While this is currently a working program, there are always things to improve upon. Here are some ideas that I may implement in the future:
- Using knowledge from previous class and personal projects, add an account system so that anyone can create and login to an account to use this program.
- Set up the server somewhere in which it can run continuously.
- Add greater error handling. Right now, errors will simply result in the stack trace being printed with unknown program behaviour.
- Learn how to send notifcations to the computer rather than relying on text via email. This would require more server work as well as different user functions for the one checking in and the one recieving notifications.
- Reduce the restrictions placed on the user when inputting phone numbers by parsing the list of phone numbers and removing spaces, parentesis, and dashes for them.
- Modernize the user experience of adding phone numbers.
- Add handling to ensure the inputted phone numbers are 10 digits in length.
- Consider learning how to make this into a usable app for a smartphone.

## About the Programmer
Jonathan Maskew, Purdue University Computer Science Student

Began work on program in August 2021. This is a personal project. I completed it for my own benefit.
