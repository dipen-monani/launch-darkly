# LaunchDarklyDemo

[![api](https://img.shields.io/badge/api-documentation-green.svg)](https://launchdarkly.com/docs/api)
![java version](https://img.shields.io/badge/java-21-ED8B00?logo=java&logoColor=white-pink.svg)

> Orchestrator service of the booking flow

## Steps to create account in launch darkly

-> https://app.launchdarkly.com/signup

-> Fill use details or sign up with Google account

-> Follow the instruction and then create the flag

In below image we have created sample feature flag
![image](https://github.com/user-attachments/assets/0ca93956-a25e-4959-8a9f-dd3b1b375c67)


We can create a new flag and set the specific rule which scenario we need to enable this flag

We can copy `sdkKey` from environment https://app.launchdarkly.com/projects/default/settings/environments?env=test&selected-env=test and use that `sdkKey` in our code

we can create multiple environment like QA, DEV, PROD and get the environment specific `sdkKey`
