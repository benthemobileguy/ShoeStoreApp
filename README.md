# README file for UDACITY Shoe Navigation project

This project is a sample Android application that demonstrates the use of Navigation component in Android. The app has three screens: Login, Welcome, and Shoe List. The project is available on GitHub, and these are the instructions to run the app on your local machine.



### Prerequisites

*  Android Studio

*  Basic knowledge of Android development

*  Knowledge of the Navigation component in Android.

|Login|Onboarding|Instruction screen 1|Instruction screen 2|Shoes list|Shoe detail|
|---|---|---|---|---|---|
|![login](https://github.com/luismikg/ShoeStoreInventory/blob/imagesForReadme/images/login.png)|![welcome](https://github.com/luismikg/ShoeStoreInventory/blob/imagesForReadme/images/welcome.png)|![instruction1](https://github.com/luismikg/ShoeStoreInventory/blob/imagesForReadme/images/instruction_1.png)|![instruction2](https://github.com/luismikg/ShoeStoreInventory/blob/imagesForReadme/images/instruction_2.png)|![list](https://github.com/luismikg/ShoeStoreInventory/blob/imagesForReadme/images/shoe_list.png)|![detail](https://github.com/luismikg/ShoeStoreInventory/blob/imagesForReadme/images/shoe_detail.png)|

## Rubric followed for the Project

1. Clone the repository to your local machine.

2. Open the starter project in Android Studio.

3. Add the navigation libraries to the app build.gradle file.

4. Add the safe-arg plugin to the main and app build.gradle file.

5. Set DataBindingUtil in build.gradle.

6. Use DataBindingUtil to inflate every layout.

7. Create a new navigation XML file.

8. Create a new Login destination that includes email and password labels and fields, as well as buttons for creating a new login and logging in with an existing account.

9. Create a new Welcome Screen destination that includes at least two TextViews and a navigation button with actions to navigate to the instructions screen.

10. Create a new Instructions destination that includes at least two TextViews with appropriate information and a navigation button with actions to navigate to the shoe list screen.

11. Create a class that extends ViewModel and use a LiveData field that returns the list of shoes.

12. Create a new Shoe List destination that includes a ScrollView, a LinearLayout inside the ScrollView for Shoe Items, and a FloatingActionButton with an action to navigate to the shoe detail screen.

13. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration

14. In the shoe list screen, add a Logout menu that will appear only on the shoe list screen and will return the user to the login screen.

15. Create a new screen to add shoes to the list and thereafter add to the list page

16. Create a new Shoe Detail destination that includes a TextView label and EditView for the Shoe Name, Company, Shoe Size, and Description, a Cancel button with an action to navigate back to the shoe list screen, and a Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model.

17. Make sure you can't go back to Onboarding screens.

18. In the Shoe List screen, use an Activity level ViewModel to hold a list of Shoes and observe the shoes variable from the ViewModel.

19. Add a new layout item into the ScrollView for each shoe.


## License

Copyright 2022 Luis Miguel Cabral Guzmán

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
