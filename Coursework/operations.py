from read import readingFile
d = readingFile()

def landRentalFunctions():
    isRunning = True
    
    while isRunning == True: #running the loop until loopRunning is false
        try:
            print("\t\t\t\t\t     Welcome To Land Rental.")
            print("\t\t\t\t\t     What would you like to do?")
            print("\t\t\t\t\t     1 - Rent a land")
            print("\t\t\t\t\t     2 - Return a rented land")
            print("\t\t\t\t\t     3 - Exit")
            userChoice =  int(input("\n\t\t\t\t\t     Enter your choice: "))

            #if user chooses option 1, land renting code runs
            
            if userChoice == 1:
                print("\n\t\t\t\t\t This is the land list.\n\n")
                print("Kitta \t\t City    \t\tDirection        Anna\t        Price\t\t Availability")
                print("_"*121)
                
                file = open("land.txt", "r")
                for line in file:
                    print(line.replace(",", "\t\t"))
                    #firstly replacing , with double tab space and then printing file content
                    print("_"*121)
                    #printing 121 _
                file.close()

                #creating a loop that asks the user if s/he wants to rent again
                rentAgainBool = True 
                while rentAgainBool == True:
                    #handeling ValueError of kittaId
                    isAskedId = False
                    while isAskedId == False:
                        try:
                            kittaId = int(input("\nEnter the Kitta number of the land you want to rent: "))
                            # Check if user inputted id is in list
                            if(kittaId in d.keys() and d[kittaId][-1] == " Available"):
                                #loop keeps running until user enters string
                                    isAskedName = False
                                    while isAskedName == False:
                                        userName = input("\nEnter your name: ")
                                        isString = True  #assuming user inputted string
                                        for char in userName:
                                            if char not in "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ":
                                                isString = False
                                                break
                                        if isString:
                                            isAskedName = True
                                        else:
                                            print("Enter a valid name")

                                    isAskedContact = False
                                    is10Numbered = False #assuming user didn't input 10 digits
                                    while isAskedContact == False and is10Numbered == False:
                                        contactNum = input("\nEnter your phone number: ")
                                        isString = False
                                        for chars in contactNum:
                                            #converting each chars to lowercase to check ASCII value
                                            if "a" <= chars.lower() and chars.lower() <= "z":
                                                isString = True
                                                break
                                        if isString == True:
                                            print("Enter non-string phone number.")
                                        else:
                                        #finally, only if non-string 10 digits are entered, the entered number is accepted
                                            if len(contactNum) == 10:
                                                is10Numbered = True
                                                isAskedContact = True
                                            else:
                                                print("Enter 10 digits.")

                                    #handeling ValueError of month
                                    isAskedMonth = False
                                    while isAskedMonth == False:
                                        try:
                                            rentMonth = int(input("\nHow many months do you want to rent it for? "))
                                            isAskedMonth = True
                                        except ValueError:
                                            print("ValueError. Enter month in number.")
                                    
                                    repeatRent = True
                                    while repeatRent == True:
                                        rentAgain = input("\nDo you want to rent again? (y/n): ")
                                        if rentAgain.lower() == "y":
                                            rentAgainBool = True
                                            repeatRent = False
                                            #if user wants to rent again, this while loop wont run again, but upper loop to rent runs again
                                        elif rentAgain.lower() == "n":
                                            rentAgainBool = False
                                            repeatRent = False
                                            #if user doesn't want to rent again, this while loop and upper rent again loop wont run again
                                        else:
                                            print("Error")
                            else:
                                if kittaId not in d.keys():
                                    print("Our company doen't have access to that land.")
                                else:
                                    print("Sorry, that land is not available right now. Please rent a land that is available")
                                    
                            
                        except ValueError:
                            print("ValueError. Enter a valid Kitta number from the above list.")


            ##if user chooses option 2, land returning code runs
            elif userChoice == 2:
                print("\t\t\t\t\t Thank you for choosing our service. Come back again!!\n\n")

            #if user chooses option 3, loop is terminated
            elif userChoice == 3:
                isRunning = False

            #if user provides numbers other than 1, 2, 3; the user is asked to try again
            else:
                print("\n\t\t\t\t\t Invalid Input! Try Again with available numbers.\n\n")

        #if numeric value is entered, the user is asked to try again
        except ValueError:
                print("\n\t\t\t\t\t ValueError Found!! Try using available numbers to go forward with the operation.\n\n")

landRentalFunctions() #######docstring nabirsi arpeet#######
