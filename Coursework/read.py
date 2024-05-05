def readingFile():
    """Reads a file called land.txt and writes them in a list and a dictionary

    There are no parameters in this function.

    Returns:
    Dictionary: landDict, keys are integers and values are lists.
    """
    
    file = open("land.txt", "r")
    lines = file.readlines()
    landDict = {}
    for line in lines:
        line = line.replace("\n", "") #removing new line at the end of each line using replace function
        list_ = line.split(",") #splitting into parts wherever , is found
        
        key = int(list_[0]) #the first item of each line is assigned to variabe 'key'
        value=[]
        for i in range(1,len(list_)):
            value.append(list_[i]) #list named 'value' has all datas except first one
        
        landDict[key] = value #in dictionary landDict, each key is assigned it's value like it was in the text file
    file.close()
    return landDict
