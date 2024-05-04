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


def writeToLandFile(landDict):
    """
    Writes land data the file: land.txt

    Parameter: landDict
    """
    try:
        file = open("land.txt", "w")
        
        for key, value in landDict.items():
            file.write(str(key))  #converting key to string explicitly
            for item in value:
                file.write("," + item)  #joining the items in the value list with ", " separator
            file.write("\n") #next line after each iteration
            
        file.close()

    except IOError as e:
        #the exception object e captures information about the error. This information can be useful for debugging or providing more detailed
        #error messages. In this case, specific error(e) is printed out.
        print("Writing error to file:", e)


def rentBills(landDict, name, phn, address):
    """
    This function generates a bill/invoice after the user rents land based on user's personal and rental information.
    
    This function has parameters namely; landDict, name, phn, address
        
    This function doesn't return anything.
    """
    dateTimeNow = currentDateTime()
    
    #a unique filename is generated using current time and user's name
    fileName = dateTimeNow + "_" + name + "_" + "rented"+ ".txt"

    #the file is opened and "Hello" user is written on it
    file = open(fileName, "w")

    print("="*130)
    file.write("="*130 + "\n")
    print("\t\t\t\t\t\t\t   TechnoPropertyNepal\n\t\t\t\t\t\t\t   Seti O.p. Marg 556\n\t\t\t\t\t\t\t   Kathmandu 44600")
    file.write("\t\t\t\t\t\t\t   TechnoPropertyNepal\n\t\t\t\t\t\t\t   Seti O.p. Marg 556\n\t\t\t\t\t\t\t   Kathmandu 44600\n")
    print("\t\t\t\t\t\t\t   +01-5147400")
    file.write("\t\t\t\t\t\t\t   +01-5147400\n")
    print("="*130)
    file.write("="*130 + "\n")
    print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t Date: " + dateTimeNow.split("_")[0])
    file.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t Date: " + dateTimeNow.split("_")[0] + "\n")
    print("Bill Type: Rent")
    file.write("Bill Type: Rent\n")
    print("Billed To:" + name)
    file.write("Billed To: " + name + "\n")
    print("Provided Contact Info: " + phn)
    file.write("Provided Contact Info: " + phn + "\n")
    print("Provided Address: " + address + "\n\n")
    file.write("Provided Address: " + address + "\n\n\n")
    
    print("-"*130)
    file.write("-"*130 + "\n")
    print("Kitta Id     \t City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price")
    print("-"*130)
    file.write("Kitta Id     \t City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price\n")
    file.write("-"*130 + "\n")

    totalPrice = 0
    for key, value in landDict.items():
        print(str(key) + "\t\t" + value[0] + "\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t     " + value[4] + "    \t\t" + value[5])
        file.write(str(key) + "\t\t" + value[0] + "\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t     " + value[4] + "    \t\t" + value[5] + "\n")
        totalPrice += float(value[5])
        
    print("-"*130)
    file.write("-"*130 + "\n")
    
    print("\n\nTotal Amount of all lands rented: ", str(totalPrice))
    file.write("\n\nTotal Amount of all lands rented: " + str(totalPrice) + "\n")
    
    print("="*130)
    file.write("="*130 + "\n")
    file.close()


def changingAvailabilityRent(landDict):
    """
    This function changes the availablity (on the text file) of the land after it has been rented
    It has a parameter: landDict
    """
    writeToLandFile(landDict)


def returnBills(landDict, name, phn, address, returnMonth, rentMonth, countMonth):
    """
    This function generates a bill/invoice after user returns land based on user's personal and rental information.
    
    This function has parameters namely; landDict, name, phn, address, returnMonth, rentMonth, countMonth.
        
    This function doesn't return anything.
    """
    dateTimeNow = currentDateTime()
    
    #a unique filename is generated using current time and user's name
    fileName = dateTimeNow + "_" + name + "_" + "returned"+ ".txt"

    #the file is opened and "Hello" user is written on it
    file = open(fileName, "w")

    print("="*166)
    file.write("="*166 + "\n")
    print("\t\t\t\t\t\t\t\t\t TechnoPropertyNepal\n\t\t\t\t\t\t\t\t\t Seti O.p. Marg 556\n\t\t\t\t\t\t\t\t\t Kathmandu 44600")
    file.write("\t\t\t\t\t\t\t\t\t TechnoPropertyNepal\n\t\t\t\t\t\t\t\t\t Seti O.p. Marg 556\n\t\t\t\t\t\t\t\t\t Kathmandu 44600\n")
    print("\t\t\t\t\t\t\t\t\t +01-5147400")
    file.write("\t\t\t\t\t\t\t\t\t +01-5147400\n")
    print("="*166)
    file.write("="*166 + "\n")
    print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Date: " + dateTimeNow.split("_")[0])
    file.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Date: " + dateTimeNow.split("_")[0] + "\n")
    print("Bill Type: Return")
    file.write("Bill Type: Return\n")
    print("Billed To:" +  name)
    file.write("Billed To: " + name + "\n")
    print("Provided Contact Info: " + phn)
    file.write("Provided Contact Info: " + phn + "\n")
    print("Provided Address: " + address + "\n\n")
    file.write("Provided Address: " + address + "\n\n\n")
    
    print("-"*166)
    file.write("-"*166 + "\n")
    print("Kitta Id     \t City  \t\t  Direction \t      Anna\t       Price \t      Rented For\tReturned At  \t Total Price \t    Total Price After Fine")
    print("-"*166)
    file.write("Kitta Id     \t City  \t\t  Direction \t      Anna\t       Price \t\t Rented For \t Returned At  \t Total Price \t    Total Price After Fine\n")
    file.write("-"*166 + "\n")

    totalAmountAfterFine = 0
    totalAmount = 0
    for key, value in landDict.items():
        print(str(key) + "\t\t" + value[0] + "\t   " + value[1] + "\t\t" + value[2] + "\t       " + value[3] + " \t\t   " + str(rentMonth) + "\t\t    " + value[4] + "  \t\t  " + value[5] + "\t\t      " + value[6])
        file.write(str(key) + "\t\t" + value[0] + "\t   " + value[1] + "\t\t" + value[2] + "\t       " + value[3] + " \t\t   " + str(rentMonth) + "\t\t    " + value[4] + "  \t\t  " + value[5] + "\t\t      " + value[6] + "\n")
        totalAmount += float(value[5])
        totalAmountAfterFine += float(value[6])
        
    print("-"*166)
    file.write("-"*166 + "\n")

    print("\n\nTotal Amount: ", str(totalAmount))
    file.write("\n\nTotal Amount: " + str(totalAmount) + "\n")
    
    print("Total Amount after fine: ", str(totalAmountAfterFine))
    file.write("Total Amount after fine: " + str(totalAmountAfterFine) + "\n")
            
    print("="*166)
    file.write("="*166 + "\n")
    file.write("\n")
    file.close()
    

def changingAvailabilityReturn(landDict):
    """
    This function changes the availablity (on the text file) of the land after it has been returned
    Has a parameter - landDict.
    """
    writeToLandDict(landDict)
