import datetime

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
    dateTimeNow = currentDateTime()
    
    #a unique filename is generated using current time and user's name
    fileName = dateTimeNow + "_" + name + ".txt"

    #the file is opened and "Hello" user is written on it
    file = open(fileName, "w")

    print("-"*130)
    file.write("-"*130 + "\n")
    print("\t\t\t\t\t\t\t\tInvoice\n")
    file.write("\t\t\t\t\t\t\t\tInvoice\n\n")
    print("\t"*16 + "  " + "-")
    print("-"*130)
    file.write("-"*130 + "\n")
    print("Billed To:",  name)
    file.write("Billed To: " + name + "\n")
    print("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600")
    file.write("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600\n")
    print("Date:", dateTimeNow.split("_")[0])
    file.write("Date: "+ dateTimeNow.split("_")[0] + "\n")
    print("Time:", dateTimeNow.split("_")[1])
    file.write("Time: "+ dateTimeNow.split("_")[1] + "\n")
    print("\n")

    print("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price")
    print("-"*130)
    file.write("Kitta \t\t   City  \t\t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price\n")
    file.write("-"*130 + "\n")

    totalPrice = 0
    for key, value in d.items():
        print(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t      " + value[4] + " \t     " + value[5])
        file.write(str(key) + "\t\t" + value[0] + "\t\t  " + value[1] + " \t\t " + value[2] + "\t\t" + value[3] + " \t      " + value[4] + " \t     " + value[5] + "\n")
        totalPrice += int(value[5])
    print("\n\nTotal Price of all lands rented: ", str(totalPrice) + "\n")
    file.write("\n\nTotal Price of all lands rented: " + str(totalPrice) + "\n\n")
    print("-"*130)
    file.write("-"*130 + "\n")
    print("\n\n")
    file.write("\n\n\n")
    file.close()

    

