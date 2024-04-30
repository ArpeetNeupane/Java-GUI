def readingFile():
    """Reads a file called land.txt and writes them in a list and a dictionary

    This function removes the escape sequence '\n' and splits the words wherever there is a comma. the values are put in a list while keys in
    a variable called key. The empty dictionary created at the beginning has all key value pair stored from the file 'land.txt'.

    There are no parameters in this function.

    Returns:
    Dictionary: d, keys are integers and values are lists.
    """
    
    file = open("land.txt", "r")
    lines = file.readlines()
    d = {}
    for line in lines:
        line = line.replace("\n", "") #removing new line at the end of each line using replace  function
        list_ = line.split(",") #splitting into parts wherever , is found
        
        key = int(list_[0]) #the first item of each line is assigned to variabe 'key'
        value=[]
        for i in range(1,len(list_)):
            value.append(list_[i]) #list named 'value' has all datas except first one
        
        d[key] = value #in dictionary d, each key is assigned it's value like it was in the text file
    file.close()
    return d
