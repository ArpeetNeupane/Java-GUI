from read import readingFile
from write import rentBills
from write import returnBills
from write import changingAvailabilityRent
from write import changingAvailabilityReturn

landDict = readingFile()

def landRentalFunctions():
    """This function implements a land rental system.
    It provides a menu to the user with 3 options being:
    1. to rent land
    2. return rented landor
    3. exit the system.
    This function doesn't have a parameter and doesn't return anything either.
    """
    isRunning = True
    dict_ = {} #dictionary for storing rented values
    while isRunning == True: #running the loop until loopRunning is false
        try:
            #showing lands that the company controls in a list
            print("\n")
            print("-"*105)
            print("\t\t\t\t\t\t Land List")
            print("-"*105)
            print("\nKitta \t\t City    \t\tDirection        Anna\t        Price\t\t Availability")
            print("_"*105)
                
            file = open("land.txt", "r")
            for line in file:
                print(line.replace(",", "\t\t"))
                #firstly replacing , with double tab space and then printing file content
                print("_"*105)
                #printing 105 _
            file.close()
            
            print("Welcome To Land Rental.")
            print("\n\nWhat would you like to do?")
            print("1 - Rent a land")
            print("2 - Return a rented land")
            print("3 - Exit")
            userChoice =  int(input("\nEnter your choice: "))

            #if user chooses option 1, land renting code runs
            if userChoice == 1:
                dict_ = {} #making dict_ empty for the next time the loop runs

                #showing lands that the company controls in a list
                print("\n")
                print("-"*105)
                print("\t\t\t\t\t\t Land List")
                print("-"*105)
                print("\nKitta \t\t City    \t\tDirection        Anna\t        Price\t\t Availability")
                print("_"*105)
                
                file = open("land.txt", "r")
                for line in file:
                    print(line.replace(",", "\t\t"))
                    #firstly replacing , with double tab space and then printing file content
                    print("_"*105)
                    #printing 105 _
                file.close()
                    
                #name - loop keeps running until user enters string
                isAskedName = False
                while isAskedName == False:
                    userName = input("\nEnter your name: ")
                    isString = True  #assuming user inputted string
                    for char in userName:
                        if char not in "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ":
                            isString = False
                            break
                    if isString == True and not userName == "" and not userName == " ":
                        #user cannot enter whitespace or null
                        isAskedName = True
                    else:
                        print("Please enter a valid name.")

                #address - loop keeps running until user enters string
                isAskedAddress = False
                while isAskedAddress == False:
                    userAddress = input("\nWhere do you live? ")
                    isString = True  #assuming user inputted string
                    for char in userAddress:
                        if char not in "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ":
                            isString = False
                            break
                    if isString == True and not userAddress == "" and not userAddress == " ":
                        #user cannot enter whitespace or null
                        isAskedAddress = True
                    else:
                        print("Please enter a valid address.")

                #making sure contact number is 10 digits long and non-string
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

                    
                #creating a loop that asks the user if s/he wants to rent again
                rentAgainBool = True 
                while rentAgainBool == True:
                    #handeling ValueError of kittaId
                    try:
                        kittaId = int(input("\nEnter the Kitta number of the land you want to rent: "))
                        # Check if user inputted id is in list
                        if kittaId in landDict.keys() and landDict[kittaId][-1] == " Available":
                            
                            #handeling ValueError of month
                            isAskedMonth = False
                            while isAskedMonth == False:
                                try:
                                    monthZero = True
                                    while monthZero == True:
                                        rentsMonth = int(input("\nHow many months do you want to rent it for? "))
                                        if rentsMonth <= 0:
                                            print("Rent for at least one month.")
                                        else:
                                            monthZero = False
                                            isAskedMonth = True
                                except ValueError:
                                    print("ValueError. Enter month in numbers.")

                            #changing availability in dictionary so that the user can't rent same land again
                            landDict[kittaId][4] = " Not Available"

                            totalPrice = int(landDict[kittaId][3])*rentsMonth
                                    
                            dict_[kittaId] = [landDict[kittaId][0], landDict[kittaId][1], landDict[kittaId][2], landDict[kittaId][3], str(rentsMonth), str(totalPrice)]
                                   
                            repeatRent = True
                            while repeatRent == True:
                                rentAgain = input("\nDo you want to rent again? (y/n): ")
                                if rentAgain.lower() == "y":
                                    #showing lands that the company controls in a list
                                    print("\n")
                                    print("-"*105)
                                    print("\t\t\t\t\t\t Land List")
                                    print("-"*105)
                                    print("\nKitta \t\t City    \t\tDirection        Anna\t        Price\t\t Availability")
                                    print("_"*105)
                                    
                                    file = open("land.txt", "r")
                                    for line in file:
                                        print(line.replace(",", "\t\t"))
                                        #firstly replacing , with double tab space and then printing file content
                                        print("_"*105)
                                        #printing 105 _
                                    file.close()
                                    
                                    rentAgainBool = True
                                    repeatRent = False
                                    #if user wants to rent again, this while loop wont run again, but upper loop to rent runs again
                                elif rentAgain.lower() == "n":
                                    print("\n")
                                    rentAgainBool = False
                                    repeatRent = False
                                    #if user doesn't want to rent again, this while loop and upper rent again loop wont run again
                                    rentBills(dict_, userName, contactNum, userAddress)
                                    #calling function which changes data in land.txt from available to not available
                                    #after user has rented
                                    changingAvailabilityRent(landDict)
                                             
                                else:
                                    print("Choose option 'y' for yes and 'n' for no")
                        else:
                            if kittaId not in landDict.keys():
                                print("Our company doesn't have access to that land.")
                            else:
                                print("Sorry, that land has already been rented. Please rent a land that is available.")
                                   
                         
                    except ValueError:
                        print("ValueError. Enter a valid Kitta number from the above list.")


            ##if user chooses option 2, land returning code runs
            elif userChoice == 2:
                dict_ = {} #making dict_ empty for the next time the loop runs
                #name - loop keeps running until user enters string
                isAskedName = False
                while isAskedName == False:
                    returnUserName = input("\nEnter your name: ")
                    isString = True  #assuming user inputted string
                    for char in returnUserName:
                        if char not in "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ":
                            isString = False
                            break
                        
                    if isString == True and not returnUserName == "" and not returnUserName == " ":
                    #user cannot enter whitespace or null
                        isAskedName = True
                    else:
                        print("Enter a valid name")

                #address - loop keeps running until user enters string
                isAskedAddress = False
                while isAskedAddress == False:
                    userAddress = input("\nWhere do you live? ")
                    isString = True  #assuming user inputted string
                    for char in userAddress:
                        if char not in "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ":
                            isString = False
                            break
                    if isString == True and not userAddress == "" and not userAddress == " ":
                        #user cannot enter whitespace or null
                        isAskedAddress = True
                    else:
                        print("Please enter a valid address.")

                #making sure contact number is 10 digits long and non-string
                isAskedContact = False
                is10Numbered = False #assuming user didn't input 10 digits
                while isAskedContact == False and is10Numbered == False:
                    returnContactNum = input("\nEnter your phone number: ")
                    isString = False
                    for chars in returnContactNum:
                        #converting each chars to lowercase to check ASCII value
                        if "a" <= chars.lower() and chars.lower() <= "z":
                            isString = True
                            break
                        
                    if isString == True:
                        print("Enter non-string phone number.")
                    else:
                        #finally, only if non-string 10 digits are entered, the entered number is accepted
                        if len(returnContactNum) == 10:
                            is10Numbered = True
                            isAskedContact = True
                        else:
                            print("Enter 10 digits.")

                returnAgain = True
                isIdAvailable = True
                while returnAgain == True:
                    try:
                        while isIdAvailable == True:
                            returnId = int(input("\nWhich land would you like to return? (Enter Kitta Id): "))
                            if returnId in landDict.keys():
                                if landDict[returnId][4] == " Not Available":
                                    #changing availability in dictionary
                                    landDict[returnId][4] = " Available"
                                    isIdAvailable = False
                                else:
                                    print("The land with that id is yet to be rented.")
                                    
                            else:
                                print("Our company doesn't have access to that land.")

                        #handeling ValueError of rent month
                        isAskedMonthrent = False
                        while isAskedMonthrent == False:
                            try:
                                rentMonth = int(input("\nHow many months did you rent it for? "))
                                isAskedMonthrent = True
                            except ValueError:
                                print("ValueError. Enter month in numbers.")

                        #handeling ValueError of return month
                        isAskedMonthreturn = False
                        while isAskedMonthreturn == False:
                            try:
                                returnMonth = int(input("\nHow many months has it been since you rented it? "))
                                isAskedMonthreturn = True

                            except ValueError:
                                print("ValueError. Enter month in numbers.")

                        totalPrice = ( int(landDict[returnId][3]) )*returnMonth
                        countMonth = 1
                        totalPriceAfterFine = ( int(landDict[returnId][3]) )*returnMonth #if not fined, totalPriceAfterFine = totalPrice

                        if returnMonth > rentMonth:
                            countMonth = returnMonth - rentMonth
                            totalPriceAfterFine = 0
                            totalPriceAfterFine = ( (int(landDict[returnId][3]))*returnMonth ) + FineForContractBreachers(totalPrice, countMonth)
                            
                        dict_[returnId] = [landDict[returnId][0], landDict[returnId][1], landDict[returnId][2], landDict[returnId][3], str(returnMonth), str(totalPrice), str(totalPriceAfterFine)]

                        #asking the user if s/he wants to return rented land again
                        repeatReturn = True
                        while repeatReturn == True:
                            returnLandRepeat = input("\nWould you like to return a rented land again? (y/n): ")
                            if returnLandRepeat.lower() == "y":
                                #showing lands that the company controls in a list
                                print("\n")
                                print("-"*105)
                                print("\t\t\t\t\t\t Land List")
                                print("-"*105)
                                print("\nKitta \t\t City    \t\tDirection        Anna\t        Price\t\t Availability")
                                print("_"*105)
                                    
                                file = open("land.txt", "r")
                                for line in file:
                                    print(line.replace(",", "\t\t"))
                                    #firstly replacing , with double tab space and then printing file content
                                    print("_"*105)
                                    #printing 105 _
                                file.close()
                                
                                returnAgain = True
                                repeatReturn = False
                                isIdAvailable = True
                            elif returnLandRepeat.lower() == "n":
                                returnAgain = False
                                repeatReturn = False
                                #calling bill generating function
                                print("\n\n")
                                returnBills(dict_, returnUserName, returnContactNum, userAddress, returnMonth, rentMonth, countMonth)
                                changingAvailabilityReturn(landDict) #changing availability in land.txt
                            else:
                                print("Choose option 'y' for yes and 'n' for no")
                            
                    except ValueError:
                        print("ValueError. Enter valid Kitta number from the above list.")
                        
                print("Thank you for choosing our service. Would you like to rent/return again?\n\n\n")

            #if user chooses option 3, loop is terminated
            elif userChoice == 3:
                print("Come back again!!")
                isRunning = False

            #if user provides numbers other than 1, 2, 3; the user is asked to try again
            else:
                print("\nInvalid Input! Try Again with available numbers.\n\n")

        #if numeric value is entered, the user is asked to try again
        except ValueError:
                print("ValueError Found!! Try using available numbers to go forward with the operation.\n\n")



def FineForContractBreachers(totalPrice, countMonth):
    """
    This function adds fine when the contract is breached, i.e., returnMonth>rentMonth
    
    It has 2 parameters: totalPrice, countMonth

    It returns the total price after fine is added
    """
    totalPriceAfterFine = 0
    totalPriceAfterFine += 0.1*totalPrice*countMonth
    return totalPriceAfterFine

