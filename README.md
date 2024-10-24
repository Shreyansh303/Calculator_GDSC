# Calculator GDSC
A Calculator App created in Android Studio using Java and other features for the 2nd Round Recruitment Task of GDSC NSUT's App Development Department.

Name: Shreyansh Jain

Roll Number: 2024UCS1517

## Screen 1: Calculator
This is the default activity of the App which users will be able to see after opening the app. It's layout consists of a Table Layout used inside a Linear Layout. The table layout allows for easy placement of buttons on the screen in the form of rows and columns. Above the Table layout is the display of the calculator where all digits entered will be visible to the user

The Activity contains all the basic functionalities of a calculator such as Arithmetic operations like Addition, Subtraction, Multiplication, Division and a Percentage Button. It also consists of a backspace button incase of any misinput of numbers and an AC button to clear the values. The calculator allows calculation of upto 9 digits and will display an error in case the result exceeds the value.

Many different exception handlers have been set up to prevent users from crashing the application incase of any misinput. 

At the top left of the Screen, the History Button is available to view all the recent calculations made on the calculator screeen. It redirects to the History Screen.

At the bottom left of the Screen, the Conversion Button is available to navigate to the Conversion Screen where users will be able to convert different quantities to different units as perusal.

## Screen 2: History
The History Screen has a back button at the top left which can be used the by the user to go back to the previous screen i.e. the Calculator Screen. 

The Activity makes use of a Recycler View to display all the previously made calculations by the user. If no calculations have been made the screen will remain blank.

## Screen 3: Conversion
The conversion screen same as the History Screen has a back button available at the top left of the screen to the previous screen i.e. the Calculator Screen. Upon arrival the users are presented with a Convert Drop down menu with 3 different quantities "Length, Mass and Temperature". They can choose any one of the three as per what they are looking to convert.

After choosing a Quantity, the Enter Value Text box and Unit Buttons will be available for the user to use. They can enter the value in the text box and choose the input unit from the Input Unit Buttons avaiable just below it and the desired unit to be converted to using the Output Unit Buttons avaiable below. Upon choosing an Output Unit, the result will be displayed to the users. 

Incase the users do not choose a value and attempt to click the Output Unit buttons they will be prompted with a Snack Bar with the message "Enter A Value!"
