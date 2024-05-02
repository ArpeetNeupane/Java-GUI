import datetime
from read import readingFile

landDict = readingFile()

def currentDateTime():
    """
    This function creates a unique filename based on current date and time and name of the user
    """
    #current date and time is being taken and put into respective variables
    year = str(datetime.datetime.now().year)
    month = str(datetime.datetime.now().month)
    day = str(datetime.datetime.now().day)
    hour = str(datetime.datetime.now().hour)
    minute = str(datetime.datetime.now().minute)
    second = str(datetime.datetime.now().second)

    dateTimeNow = year + "-" + month + "-" + day + "_" + hour + "-" + minute + "-" + second

    return dateTimeNow

currentDateTime()


def rentBills(landDict, name, phn, address):
    """
    This function generates a bill/invoice after the user rents land based on user's personal and rental information.

    This function generates a bill after the user has entered his/her information and land renting information and also writes
    it on a text file which has a unique name every time it is generated as the name is based on current date and time and
    the user's name. The bill can also be viewed in the text file.
    
    This function takes 3 parameters namely; d, name, phn
        landDict - a dictionary which contains values read from land.txt which is a text file containing lands' information.
        name - user's name
        phn - user's contact information
        address - user's address; living location
        
    This function doesn't return anything.
    """
    dateTimeNow = currentDateTime()
    
    #a unique filename is generated using current time and user's name
    fileName = dateTimeNow + "_" + name + "_" + "rented"+ ".txt"

    #the file is opened and "Hello" user is written on it
    file = open(fileName, "w")

    print("-"*129)
    file.write("-"*129 + "\n")
    print("\t\t\t\t\t\t\tInvoice\n")
    file.write("\t\t\t\t\t\t\t\tInvoice\n")
    print("-"*129 + "\n")
    file.write("-"*129 + "\n\n")
    print("Bill Type: Rent")
    file.write("Bill Type: Rent\n")
    print("Billed To:",  name)
    file.write("Billed To: " + name + "\n")
    print("Provided Contact Info: ", phn)
    file.write("Provided Contact Info: " + phn + "\n")
    print("Provided Address: ", address + "\n")
    file.write("Provided Address: " + address + "\n\n")
    print("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600")
    file.write("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600\n")
    print("\t+01-5147400")
    file.write("\t+01-5147400\n")
    print("\nDate:", dateTimeNow.split("_")[0])
    file.write("\nDate: "+ dateTimeNow.split("_")[0] + "\n")
    print("Time:", dateTimeNow.split("_")[1] + "\n\n")
    file.write("Time: "+ dateTimeNow.split("_")[1] + "\n\n\n")
    
    print("-"*129)
    file.write("-"*129 + "\n")
    print("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price")
    print("-"*129)
    file.write("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price\n")
    file.write("-"*129 + "\n")

    totalPrice = 0
    for key, value in landDict.items():
        print(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "    \t\t" + value[5])
        file.write(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "    \t\t" + value[5] + "\n")
        totalPrice += float(value[5])
    print("\n\nTotal Price of all lands rented: ", str(totalPrice))
    file.write("\n\nTotal Price of all lands rented: " + str(totalPrice) + "\n")
    #13% VAT
    print("Total Price after Value Added Tax(V.A.T): ",  str( round(totalPrice*1.13, 2) )) #rounding to 2 digits
    file.write("Total Price after Value Added Tax(V.A.T): " + str( round(totalPrice*1.13, 2) ) + "\n")    
    print("-"*129)
    file.write("-"*129 + "\n")
    print("\n\n")
    file.write("\n\n")
    file.close()


def changingAvailabilityRent(landDict):
    """
    This function changes the availablity (on the text file) of the land after it has been rented
    It has a parameter: landDict - dictionary which has details about land
    """
    file = open("land.txt", "w")
    
    for key, value in landDict.items():
            file.write(str(key) + ",")  #converting key to string explicitly
            file.write(",".join(value))  #joining the items in the value list with ", " separator
            file.write("\n") #next line after each iteration
        
    file.close()


def returnBills(landDict, name, phn, address, returnMonth, rentMonth, countMonth):
    """
    This function generates a bill/invoice after user returns land based on user's personal and rental information.

    This function generates a bill after the user has chosen which land to return and also writes
    it on a text file which has a unique name every time it is generated as the name is based on current date and time and
    the user's name. The bill can also be viewed in the text file.
    
    This function takes 3 parameters namely; d, name, phn
        landDict - a dictionary which contains values read from land.txt which is a text file containing lands' information.
        name - user's name
        phn - user's contact information
        returnMonth - no. of month user returned land at
        rentMonth - no. of month user rented land for
        countMonth = difference between returnMonth and rentMonth
        
    This function doesn't return anything.
    """
    dateTimeNow = currentDateTime()
    
    #a unique filename is generated using current time and user's name
    fileName = dateTimeNow + "_" + name + "_" + "returned"+ ".txt"

    #the file is opened and "Hello" user is written on it
    file = open(fileName, "w")

    print("-"*165)
    file.write("-"*165 + "\n")
    print("\t\t\t\t\t\t\t\t    Invoice\n")
    file.write("\t\t\t\t\t\t\t\t\t    Invoice\n")
    print("-"*165 + "\n")
    file.write("-"*165 + "\n\n")
    print("Bill Type: Return")
    file.write("Bill Type: Return\n")
    print("Billed To:",  name)
    file.write("Billed To: " + name + "\n")
    print("Provided Contact Info: ", phn)
    file.write("Provided Contact Info: " + phn + "\n")
    print("Provided Address: ", address + "\n")
    file.write("Provided Address: " + address + "\n\n")
    print("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600")
    file.write("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600\n")
    print("\t+01-5147400")
    file.write("\t+01-5147400\n")
    print("\nDate:", dateTimeNow.split("_")[0])
    file.write("\nDate: "+ dateTimeNow.split("_")[0] + "\n")
    print("Time:", dateTimeNow.split("_")[1] + "\n\n")
    file.write("Time: "+ dateTimeNow.split("_")[1] + "\n\n\n")
    
    print("-"*165)
    file.write("-"*165 + "\n")
    print("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price \t    Total Price After Fine")
    print("-"*165)
    file.write("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price \t    Total Price After Fine\n")
    file.write("-"*165 + "\n")

    totalPriceAfterFine = 0
    for key, value in landDict.items():
        print(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "    \t\t" + value[5] + "\t\t\t" + value[6])
        file.write(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "    \t\t" + value[5] + "\t\t\t" + value[6] + "\n")
        totalPriceAfterFine += float(value[6])
        
    print("\n\nTotal Amount of all lands rented: ", str(totalPriceAfterFine))
    file.write("\n\nTotal Price of all lands rented: " + str(totalPriceAfterFine) + "\n")

    if returnMonth > rentMonth:
        print("You were fined as you exceeded the time limit of the contract.")
        file.write("You were fined as you exceeded the time limit of the contract.\n")
        
    vattedRoundedPrice =  roundingAndVat(totalPriceAfterFine, 2) 
    #13% VAT
    print("Total Price after Value Added Tax(V.A.T): ",  str(vattedRoundedPrice)) #rounding to 2 digits
    file.write("Total Price after Value Added Tax(V.A.T): " + str(vattedRoundedPrice) + "\n")
            
    print("-"*165)
    file.write("-"*165 + "\n")
    file.write("\n")
    file.close()


def roundingAndVat(totalAmount, decimalPlace):
    """
    This function rounds the given number to the specified number of decimal places, i.e., returnMonth>rentMonth
    It has parameters:
    totalAmount - amount after fine before V.A.T, the number to round-off
    decimalPlace - the number of decimal places to round-off to
    It returns the amount after V.A.T has been added
    """
    ##shifting the decimal to the right by number user provides
    totalAmount = 1.13 * totalAmount
    factor = 10 ** decimalPlace
    roundedNumber = totalAmount * factor
    roundedNumber += 0.5
    roundedNumber = int(roundedNumber)
    #shifting decimal point back to original position
    roundedNumber /= factor
    return roundedNumber
    

def changingAvailabilityReturn(landDict):
    """
    This function changes the availablity (on the text file) of the land after it has been returned
    """
    file = open("land.txt", "w")
    
    for key, value in landDict.items():
            file.write(str(key) + ",")  #converting key to string explicitly
            file.write(",".join(value))  #joining the items in the value list with ", " separator
            file.write("\n") #next line after each iteration
        
    file.close()
