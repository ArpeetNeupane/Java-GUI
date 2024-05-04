from read import readingFile
from write import rentBills
from write import returnBills
from write import changingAvailabilityRent
from write import changingAvailabilityReturn

landDict = readingFile()
dict_ = {}

isRunning = True
def renting():
    """
    This function asks users for information about them and the land they want to rent and the land is rented to the user.
    """
    dict_ = {} #making dict_ empty for the next time the loop runs
    uniqueUserDict = {}

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
            #checking if user inputted id is in list
            if kittaId in landDict.keys() and landDict[kittaId][-1] == " Available":
                #asking user for anna for validation
                print("\nYou can only rent the exact amount of anna the land has; no more no less.")
                isAskedAnna = False
                while isAskedAnna == False:
                        try:
                            askingAnna = int(input("\nHow many annas do you want to rent? "))
                            availableAnna = int(landDict[kittaId][2])
                              
                            if not askingAnna == availableAnna:
                                print("Only specified anna is available to rent.")
                            else:
                                isAskedAnna = True
                        except:
                            print("Value Error. Enter anna in numbers.")
                    
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
                            #changing availability in dictionary so when list is printed, list is updated
                            changingAvailabilityRent(landDict)
                              
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



def returning():
    """
    This function asks users for information about them and the land they have rented and the land is returned to the company.
    """
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
                    #changing availability in dictionary so when list is printed, list is updated
                    changingAvailabilityReturn(landDict)
                         
                    #showing lands that the company controls in a list
                    print("\n")
                    print("="*105)
                    print("\t\t\t\t\t\t Land List")
                    print("="*105)
                    print("\nKitta Id      \t City    \t\tDirection        Anna\t        Price\t\t Availability")
                              
                    file = open("land.txt", "r")
                    for line in file:
                        print("-"*105)
                        #printing 105 _
                        print(line.replace(",", "\t\t"))
                        #replacing , with double tab space and then printing file content
                    print("="*105)
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


    

def FineForContractBreachers(totalPrice, countMonth):
    """
    This function adds fine when the contract is breached, i.e., returnMonth>rentMonth
    
    It has 2 parameters: totalPrice, countMonth

    It returns the total price after fine is added
    """
    totalPriceAfterFine = 0
    totalPriceAfterFine += 0.1*totalPrice*countMonth
    return totalPriceAfterFine
