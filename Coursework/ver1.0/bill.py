
def rentBills(d, name, phn):
    print("\t\t\t\t\t\t\t\tInvoice\n")
    print("Billed To:", name)
    print("Pay To: TechnoPropertyNepal\n\tSeti O.p. Marg 556\n\tKathmandu 44600")
    print("Date: ", d["101"][4])
    print("Time: ", d["101"][5])
    print("\n")

    print("Kitta \t\t   City  \t  Direction \t\t Anna\t        Price \t\t Duration \t    Total Price")
    print()
    

dict_ ={"101": ["Bharatpur", "North", "6", "Aayush", "2012-12-23", "10:30:20", "20000"],
    "102": ["Lalitpur", "South", "4", "Srijan", "2012-11-23", "10:31:20", "30000"],
    "103": ["Kathmandu", "East", "9", "Srijesh", "2012-09-23", "10:32:20", "40000"]
    }

rentBills(dict_, userName, phoneNumber)
