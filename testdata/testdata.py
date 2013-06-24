#!/usr/local/bin/python2.7

import csv
import random


projects = ['COMMON', '2013-FIRSTCUSTOMER-FU', '2011-NEPTUN']
accounts = ['URLAUB','KRANK', 'AUSB', 'BERAT', 'PK-CD', 'ENTW']
areas = ['COMPANY', 'B-ALPHA', 'B-BETA']
month = ['01-2013', '02-2013', '03-2013', '04-2013', '05-2013']


with open('mitarbeiter.csv') as file:
	rowdata = []
	reader = csv.reader(file , delimiter=';')
	reader.next()
	for row in reader:
		rowdata.append(row)

with open('testdata.csv', 'wb') as csvfile:
    csvwriter = csv.writer(csvfile, delimiter=';', quoting=csv.QUOTE_NONE)
    for i in range(1,200):
    	csvwriter.writerow(random.choice(rowdata) + [random.randint(1,70), random.choice(month), random.choice(projects), random.choice(areas), random.choice(accounts),random.choice(['true','false']), random.randint(100,300), random.randint(200,400)])
