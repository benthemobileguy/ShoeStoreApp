# The Shoe Store

This project will consist of five screens. You don't have to create a shoe store, you can use any other item as long as you create the following screens. You will be creating:

|Login|Onboarding|Instruction screen 1| Shoe Details                      |Shoes list|
|---|---|---|-----------------------------------|---|
|![login](screenshots/login.png)|![welcome](screenshots/welcome.png)|![instruction1](screenshots/instructions.png)| ![Add Shoe](screenshots/shoe.png) |![list](screenshots/shoeList.png)|


1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

##Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Create a new navigation xml file

5. Create a new Login destination.

    * Include email and password labels

    - Include email and password fields
    - Create buttons for creating a new login and logging in with an existing account
    - Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

    * A new layout
    * At least 2 textviews
    * A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

    * A new layout
    * At least 2 textviews
    * A navigation button with actions to navigate to the shoe list screen

8. Create a class that extends ViewModel

    *  Use a LiveData field that returns the list of shoes

9. Create a new Shoe List destination that includes:

    * A new layout
    * A ScrollView
    * A LinearLayout for Shoe Items
    * A FloatingActionButton with an action to navigate to the shoe detail screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Shoe Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
        * Shoe Name
        * Company
        * Shoe Size
        * Description
    * A Cancel button with an action to navigate back to the shoe list screen
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

12. Make sure you can???t go back to onboarding screens

13. In the Shoe List screen:

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Use DataBindingUtil to inflate the shoe_list layout
    * Add a new layout item into the scrollview for each shoe.

---

## Review from the Reviewer (Udacity)

![review](screenshots/review.png)

---

## License

```
Copyright 2023

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
   
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```