import datetime
from read import readingFile

d = readingFile()

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


def rentBills(d, name, phn):
    """
    This function generates a bill/invoice after the user rents land based on user's personal and rental information.

    This function generates a bill after the user has entered his/her information and land renting information and also writes
    it on a text file which has a unique name every time it is generated as the name is based on current date and time and
    the user's name. The bill can also be viewed in the text file.
    
    This function takes 3 parameters namely; d, name, phn
        d - a dictionary which contains values read from land.txt which is a text file containing lands' information.
        name - user's name
        phn - user's contact information
        
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
    print("Your Contact Info: ", phn + "\n")
    file.write("Your Contact Info: " + phn + "\n\n")
    print("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600")
    file.write("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600\n")
    print("\t+01-5147400")
    file.write("\t+01-5147400\n")
    print("Date:", dateTimeNow.split("_")[0])
    file.write("Date: "+ dateTimeNow.split("_")[0] + "\n")
    print("Time:", dateTimeNow.split("_")[1] + "\n")
    file.write("Time: "+ dateTimeNow.split("_")[1] + "\n\n")
    file.write("\n")
    

    print("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price")
    print("-"*129)
    file.write("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price\n")
    file.write("-"*129 + "\n")

    totalPrice = 0
    for key, value in d.items():
        print(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "    \t\t" + value[5])
        file.write(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "    \t\t" + value[5] + "\n")
        totalPrice += int(value[5])
    print("\n\nTotal Price of all lands rented: ", str(totalPrice) + "\n")
    file.write("\n\nTotal Price of all lands rented: " + str(totalPrice) + "\n\n")
    print("-"*129)
    file.write("-"*129 + "\n")
    print("\n\n")
    file.write("\n\n")
    file.close()


def changingAvailabilityRent(d):
    """
    This function changes the availablity (on the text file) of the land after it has been rented
    """
    file = open("land.txt", "w")
    
    for key, value in d.items():
            file.write(str(key) + ",")  #converting key to string explicitly
            file.write(",".join(value))  #joining the items in the value list with ", " separator
            file.write("\n") #next line after each iteration
        
    file.close()


def returnBills(d, name, phn):
    """
    This function generates a bill/invoice after user returns land based on user's personal and rental information.

    This function generates a bill after the user has chosen which land to return and also writes
    it on a text file which has a unique name every time it is generated as the name is based on current date and time and
    the user's name. The bill can also be viewed in the text file.
    
    This function takes 3 parameters namely; d, name, phn
        d - a dictionary which contains values read from land.txt which is a text file containing lands' information.
        name - user's name
        phn - user's contact information
        
    This function doesn't return anything.
    """
    dateTimeNow = currentDateTime()
    
    #a unique filename is generated using current time and user's name
    fileName = dateTimeNow + "_" + name + "_" + "returned"+ ".txt"

    #the file is opened and "Hello" user is written on it
    file = open(fileName, "w")

    print("-"*129)
    file.write("-"*129 + "\n")
    print("\t\t\t\t\t\t\tInvoice\n")
    file.write("\t\t\t\t\t\t\t\tInvoice\n")
    print("-"*129 + "\n")
    file.write("-"*129 + "\n\n")
    print("Bill Type: Return")
    file.write("Bill Type: Return\n")
    print("Billed To:",  name)
    file.write("Billed To: " + name + "\n")
    print("Your Contact Info: ", phn + "\n")
    file.write("Your Contact Info: " + phn + "\n\n")
    print("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600")
    file.write("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600\n")
    print("\t+01-5147400")
    file.write("\t+01-5147400\n")
    print("Date:", dateTimeNow.split("_")[0])
    file.write("Date: "+ dateTimeNow.split("_")[0] + "\n")
    print("Time:", dateTimeNow.split("_")[1] + "\n")
    file.write("Time: "+ dateTimeNow.split("_")[1] + "\n\n")
    file.write("\n")
    

    print("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price")
    print("-"*129)
    file.write("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price\n")
    file.write("-"*129 + "\n")

    totalPrice = 0
    for key, value in d.items():
        print(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "     \t\t" + value[5])
        file.write(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t\t    " + value[4] + "     \t\t" + value[5] + "\n")
        totalPrice += int(value[5])
        
    print("\n\nTotal Price of all lands rented: ", str(totalPrice) + "\n")
    file.write("\n\nTotal Price of all lands rented: " + str(totalPrice) + "\n\n")
    print("You were fined as you exceeded the time limit of the contract.")
    file.write("You were fined as you exceeded the time limit of the contract.\n")
    print("-"*129)
    file.write("-"*129 + "\n")
    print("\n\n")
    file.write("\n\n")
    file.close()
    
    

def changingAvailabilityReturn(d):
    """
    This function changes the availablity (on the text file) of the land after it has been returned
    """
    file = open("land.txt", "w")
    
    for key, value in d.items():
            file.write(str(key) + ",")  #converting key to string explicitly
            file.write(",".join(value))  #joining the items in the value list with ", " separator
            file.write("\n") #next line after each iteration
        
    file.close()
