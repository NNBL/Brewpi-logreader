import pandas as pd

class DataFromCSV():
    """Parse data from a Brewpi log"""
    def __init__(self, filename = None):
        if filename is not None:
            self._filename = filename
        else:
            print "Need a filename" 
    
    def getdata(self):
        
        names = "Date", "BeerTemp", "BeerSetting", "BeerAnnotation", "FridgeTemp",\
                "FridgeSetting", "FridgeAnnotation", "RoomTemp", "State"
        
        return pd.read_csv(self._filename, sep=";", header=None, parse_dates=[0], names=names, na_values="None")        
