from operations import renting
from operations import returning

isRunning = True
dict_ = {} #dictionary for storing rented values

while isRunning == True: #running the loop until loopRunning is false
    try:
        #showing lands that the company controls in a list
        print("\n")
        print("="*105)
        print("\t\t\t\t\t\t Land List")
        print("="*105)
        print("\nKitta Id     \t City    \t\tDirection        Anna\t        Price\t\t Availability")
               
        file = open("land.txt", "r")
        for line in file:
            print("-"*105)
            #printing 105 _
            print(line.replace(",", "\t\t"))
            #replacing , with double tab space and then printing file content
        print("="*105)
        file.close()
          
        print("\n\nWelcome To Land Rental.")
        print("What would you like to do?")
        print("1 - Rent a land")
        print("2 - Return a rented land")
        print("3 - Exit")
        userChoice =  int(input("\nEnter your choice: "))

        #if user chooses option 1, land renting code runs
        if userChoice == 1:
            renting()
            print("Thank you for choosing our service.\n\n\n")

        #if user chooses option 2, land returning code runs
        elif userChoice == 2:
            returning()
            print("\nThank you for choosing our service.\n\n\n")

        #if user chooses option 3, loop is terminated
        elif userChoice == 3:
            print("Come back again!!")
            isRunning = False
            
        else:
            print("\nInvalid Input! Try again with available numbers.\n\n")

    #if numeric value is entered, the user is asked to try again
    except ValueError:
        print("ValueError Found!! Try using available numbers to go forward with the operation.\n\n")
