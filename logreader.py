from DataFromCSV import DataFromCSV
import matplotlib.pyplot as pl
import sys
import matplotlib.dates as mdates
from matplotlib import rcParams

rcParams.update({'figure.autolayout': True})

if len(sys.argv) < 2:
    print "Usage: python "+sys.argv[0]+" filename.csv"
else:
    data = DataFromCSV(sys.argv[1]).getdata()
    
    date = [d.to_datetime() for d in data["Date"]]
    pl.title("Fermentation profile for: "+sys.argv[1])
    pl.xticks(rotation=50)
    pl.plot(date,data["BeerTemp"], label="Beer temp", color="green")
    pl.plot(date,data["BeerSetting"], label="Beer setting",color="red")
    pl.plot(date,data["FridgeTemp"], label="Fridge temp",color="blue")
    pl.plot(date,data["FridgeSetting"], label="Fridge setting", color="orange")
    pl.grid()
    pl.show()
