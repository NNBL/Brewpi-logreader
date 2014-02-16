from DataFromCSV import DataFromCSV
import matplotlib.pyplot as pl
import sys

if len(sys.argv) < 2:
    print "Usage: python "+sys.argv[0]+" filename.csv"
else:
    data = DataFromCSV(sys.argv[1]).getdata()
    pl.plot(data["BeerTemp"])
    pl.plot(data["BeerSetting"])
    pl.plot(data["FridgeTemp"])
    pl.plot(data["FridgeSetting"])
    pl.show()
