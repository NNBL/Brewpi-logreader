import numpy as np
import matplotlib.pyplot as pl

class DataFromCSV():
    """Parse data from a Brewpi log"""
    def __init__(self, filename = None):
        if filename is not None:
            self._filename = filename
        else:
            print "Need a filename"

    def getdata(self):
        return np.genfromtxt(self._filename, delimiter=";", names={"Date",\
                                                                "BeerTemp",\
                                                                "BeerSetting",\
                                                                "BeerAnnotation",\
                                                                "FridgeTemp",\
                                                                "FridgeSetting",\
                                                                "FridgeAnnotation",\
                                                                "RoomTemp",\
                                                                "State"})